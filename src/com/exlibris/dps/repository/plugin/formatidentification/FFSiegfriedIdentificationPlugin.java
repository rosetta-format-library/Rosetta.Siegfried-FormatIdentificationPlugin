package com.exlibris.dps.repository.plugin.formatidentification;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


import java.lang.Object;
import java.io.File;

import com.exlibris.digitool.common.streams.ScriptUtil;
import com.exlibris.digitool.exceptions.ScriptException;
import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.core.sdk.utils.FSUtil;
import com.exlibris.dps.sdk.formatidentification.FormatIdentificationPlugin;
import com.exlibris.dps.sdk.formatidentification.FormatIdentificationResult;

public class FFSiegfriedIdentificationPlugin implements
		FormatIdentificationPlugin {

	private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
	private static String AGENT_NAME = "SIEGFRIED";
	private static String AGENT_VERSION = null;// "1.95";
	private static String REGISTRY_NAME = null;// "PRONOM";
	private static String OPERATION_SHARED_SOFTWARE = FSUtil.getProfileDir()
			+ "operational_shared/software/";
	private static String SIEGFRIED_EXECUTABLE_WINDOWS = OPERATION_SHARED_SOFTWARE
			+ "sf.exe";
	private static String SIEGFRIED_EXECUTABLE_LINUX = "sf";
	private static String SIGNATURE_FILE = OPERATION_SHARED_SOFTWARE
			+ "default.sig";
	private static String SIEGFRIED_EXECUTABLE;
	private static String AGENT_SIGNATURE_VERSION = null;

	private static final ExLogger log = ExLogger
			.getExLogger(FFSiegfriedIdentificationPlugin.class);

	/*
	 * the agent version is set in the static method, if it was changed by the user, it won't get updated, 
	 * new plugin may need to be created if the user replaces the agent version or the signature files that exist
	 */

	static {
		SIEGFRIED_EXECUTABLE = getExecNameByOS();
		copySiegfriedSignature();
		setInfo();
		
	}

	@Override
	public String getAgentName() {
		return AGENT_NAME;
	}

	private static void copySiegfriedSignature() {
		if(isLinuxOS()) {
			//Use Signature of v106, same as FFDROID as of now.
	        Path targetDirectory = Paths.get("/exlibris/dps/siegfried/default.sig");
			InputStream link = (FFSiegfriedIdentificationPlugin.class
					.getResourceAsStream("/conf/default.sig"));
			try {
				Files.copy(link, targetDirectory,
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				log.error(
						"Failed to copy Siegfried signature file default.sig from Jar",
						e);
			}
			
		}		
	}

	@Override
	public String getAgentVersion() {
		return AGENT_VERSION;
	}

	@Override
	public String getAgentSignatureVersion() {
		return AGENT_SIGNATURE_VERSION;
	}

	@Override
	public String getFormatRegistryName() {
		return REGISTRY_NAME;
	}

	@Override
	public FormatIdentificationResult identifyFormat(String filePath) {

		FormatIdentificationResult formatResults = null;
		Path path = Paths.get(filePath);
		//handle server symlinks
		if(Files.isSymbolicLink(path)) {
			try {
				filePath = path.toRealPath().toString();
			} catch (IOException e) {
				log.error("can't resolve symlink", e);

			}
		}
		SiegfriedResourceUtil siegfriedResourceUtil = new SiegfriedResourceUtil();
		List<String> args = siegfriedResourceUtil.createCommandLineArgsList(
				SIGNATURE_FILE, filePath);
		String scriptOutput = null;
		try {
			// sf -sig default.sig -json filePath
			scriptOutput = ScriptUtil.runScript(SIEGFRIED_EXECUTABLE, args);
			formatResults = siegfriedResourceUtil.parse(scriptOutput);
		} catch (Exception e) {
			log.error("Failed identify format", e);
		}
		return formatResults;
	}

	private static void setSiegfriedInfoLinux() {
		String scriptOutput = null;
		try {
			scriptOutput = ScriptUtil.runScript(SIEGFRIED_EXECUTABLE, Arrays.asList("-v"));
			String[] results = scriptOutput.split("\n");
			String output = results[1]+ results[3].substring(results[3].indexOf("pronom:")+"pronom:".length());
			AGENT_VERSION = results[0].split(" ")[1];
			REGISTRY_NAME = "PRONOM";
			AGENT_SIGNATURE_VERSION = output;
		} catch (ScriptException e) {
			log.error("Failed SiegfriedInfo fill", e);
		}
	}
	private static void setSiegfriedInfo() {
		// sf -sig default.sig -json filePath
		// run this to populate the getter methods.

		SiegfriedResourceUtil siegfriedResourceUtil = new SiegfriedResourceUtil();
		List<String> args = siegfriedResourceUtil.createCommandLineArgsList(
				SIGNATURE_FILE, SIGNATURE_FILE);
		Map<String, String> siegFriedVersionInfo = null;
		String scriptOutput = null;
		try {
			scriptOutput = ScriptUtil.runScript(SIEGFRIED_EXECUTABLE, args);
			siegFriedVersionInfo = siegfriedResourceUtil
					.parseSiegfriedVersionInfo(scriptOutput);
		} catch (ScriptException e) {
			log.error("Failed SiegfriedInfo fill", e);
		}
		AGENT_VERSION = siegFriedVersionInfo.get("agentVersion");
		REGISTRY_NAME = siegFriedVersionInfo.get("registryName");
		AGENT_SIGNATURE_VERSION = siegFriedVersionInfo
				.get("agentSignatureVersion");

	}

	
	private static Boolean isLinuxOS(){
		String osName = System.getProperty("os.name");
		if (osName.equals("Unix") || osName.equals("Linux")
				|| osName.equals("SunOS")) {
			return true;
		}
		return false;
	}
	
	private static void setInfo() {
		if (isLinuxOS()) {
			setSiegfriedInfoLinux();
		}
		else {
			setSiegfriedInfo();
		}
	}
	private static String getExecNameByOS() {
		if (isLinuxOS()) {
			SIGNATURE_FILE = null;
			try {
				String scriptOutput = ScriptUtil.runScript(SIEGFRIED_EXECUTABLE_LINUX, Arrays.asList("-update"));
			} catch (ScriptException e) {
				log.error("sf -update failed", e);
			}
			return SIEGFRIED_EXECUTABLE_LINUX;
		}
		return SIEGFRIED_EXECUTABLE_WINDOWS;
	}

}
