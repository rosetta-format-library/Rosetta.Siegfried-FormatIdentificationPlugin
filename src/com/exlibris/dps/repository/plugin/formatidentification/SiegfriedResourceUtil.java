package com.exlibris.dps.repository.plugin.formatidentification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.core.sdk.consts.Enum.FormatIdentificationMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class SiegfriedResourceUtil {

	private static final ExLogger log = ExLogger
			.getExLogger(SiegfriedResourceUtil.class);

	public SiegfriedFormatIdentificationResult parse(String scriptOutput)
			throws IOException {
		// Output has escaping slash, remove it
		ObjectMapper mapper = JsonMapper.builder()
				.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
				.build();
		SiegfriedInfo jsonOutput = mapper.readValue(scriptOutput,
				SiegfriedInfo.class);
		SiegfriedInfo.File fileInfo = jsonOutput.getFiles().get(0);
		SiegfriedFormatIdentificationResult formatResults = new SiegfriedFormatIdentificationResult();

		// fill FormatInformation map and regular results;
		for (SiegfriedInfo.Match match : fileInfo.getMatches()) {
			
			//populate the formatInformation to be added to the map
			SiegfriedFormatInformation siegfriedFormatInformation = new SiegfriedFormatInformation();
			siegfriedFormatInformation.setFormatId(match.getId());
			FormatIdentificationMethod formatIdentificationMethod = parseIdentificationMethodMatch(match);
			if(formatIdentificationMethod != null)
				siegfriedFormatInformation.setIdentificationMethod(formatIdentificationMethod);
			siegfriedFormatInformation.setWarning(match.getWarning());
			siegfriedFormatInformation.setIdentificationMethodDetails(match.getBasis());
	
			formatResults.addFormatsInformation(match.getId(), siegfriedFormatInformation);
			formatResults.setPositiveMatch(true);
			
			//populate the regular format
			formatResults.addFormat(match.getId());
			
		}
		
		FormatIdentificationMethod formatIdentificationMethod = parseIdentificationMethod(fileInfo);
		if (formatIdentificationMethod != null) {
			formatResults.setMethod(formatIdentificationMethod);
		}
		formatResults.addError(fileInfo.getErrors());
		// should handle zero hits -> it expects null
//		formatResults = formatResults.getFormats().get(0).equals("UNKNOWN") ? null
//				: formatResults;
		if( formatResults.getFormats().get(0).equals("UNKNOWN")) {
			formatResults.setFormat(null);
			formatResults.setPositiveMatch(false);

		}
		return formatResults;
	}

	public Map<String, String> parseSiegfriedVersionInfo(String scriptOutput) {
		ObjectMapper mapper = JsonMapper.builder()
				.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
				.build();
		SiegfriedInfo jsonOutput = null;
		try {
			jsonOutput = mapper.readValue(scriptOutput, SiegfriedInfo.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Failed parsing Siegfried output", e);
		}
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("agentVersion", jsonOutput.getSiegfried());
		hashMap.put("registryName", jsonOutput.getIdentifiers().get(0)
				.getName());
		hashMap.put("agentSignatureVersion", jsonOutput.getSignature() + " ("
				+ jsonOutput.getCreated() + "), "
				+ jsonOutput.getIdentifiers().get(0).getDetails());
		return hashMap;
	}

	public FormatIdentificationMethod parseIdentificationMethod(
			SiegfriedInfo.File fileInfo) {
		if (fileInfo.getMatches().size() == 1) {
			if (fileInfo.getMatches().get(0).getBasis()
					.contains("container match")) {
				return FormatIdentificationMethod.CONTAINER;
			} else if (fileInfo.getMatches().get(0).getBasis()
					.contains("byte match")) {
				return FormatIdentificationMethod.SIGNATURE;
			} else if (fileInfo.getMatches().get(0).getBasis()
					.contains("extension match")) {
				return FormatIdentificationMethod.EXTENSION;
			} else if (fileInfo.getMatches().get(0).getBasis()
					.contains("text match")) {
				return FormatIdentificationMethod.EXTENSION;
			}
		}
		return null;
	}
	
	public FormatIdentificationMethod parseIdentificationMethodMatch(
			SiegfriedInfo.Match match) {
			if (match.getBasis()
					.contains("container match")) {
				return FormatIdentificationMethod.CONTAINER;
			} else if (match.getBasis()
					.contains("byte match")) {
				return FormatIdentificationMethod.SIGNATURE;
			} else if (match.getBasis()
					.contains("extension match")) {
				return FormatIdentificationMethod.EXTENSION;
			} else if (match.getBasis()
					.contains("text match")) {
				return FormatIdentificationMethod.EXTENSION;
			}
		return null;
	}
	

	public List<String> createCommandLineArgsList(String sigFile,
			String filePath) {
		// TODO Auto-generated method stub
		List<String> args = new ArrayList<String>();
		if (StringUtils.isNotEmpty(sigFile)) {
			args.add("-sig");
			args.add(sigFile);
		}
		args.add("-json");
		args.add(filePath);
		return args;
	}
}
