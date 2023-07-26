package com.exlibris.dps.repository.plugin.formatidentification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exlibris.core.sdk.consts.Enum.FormatIdentificationMethod;
import com.exlibris.dps.sdk.formatidentification.FormatIdentificationResult;
import com.exlibris.dps.sdk.formatidentification.FormatInformation;

public class SiegfriedFormatIdentificationResult implements FormatIdentificationResult {

	private List<String> formats;
	private FormatIdentificationMethod method;

	// ValidationStackErrorConstant
	private long vsError;
	private boolean isPositiveMatch = false;
	
	private List<String> errors;
	private List<String> errorIds;
	
	Map<String, FormatInformation> formatsInformation;

	@Override
	public List<String> getFormats() {
		return formats;
	}

	@Override
	public FormatIdentificationMethod getIdentificationMethod() {
		return method;
	}

	public void setFormat(List<String> formats) {
		this.formats = formats;
	}

	public void setMethod(FormatIdentificationMethod method) {
		this.method = method;
	}

	public void addFormat(String puid) {
		if(formats == null){
			formats = new ArrayList<String>();
		}
		formats.add(puid);
	}

	public void setVsError(long vsError) {
		this.vsError = vsError;
	}

	public long getVsError() {
		return vsError;
	}

	public void setPositiveMatch(boolean isPositiveMatch) {
		this.isPositiveMatch = isPositiveMatch;
	}

	public boolean isPositiveMatch() {
		return isPositiveMatch;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}
	
	public void addError(String error) {
		if(errors == null){
			errors = new ArrayList<String>();
		}
		errors.add(error);
	}
	
	public void addErrorId(String errorId) {
		if(errorIds == null){
			errorIds = new ArrayList<String>();
		}
		errorIds.add(errorId);
	}

	@Override
	public List<String> getErrorIds() {
		return errorIds;
	}

	@Override
	public Map<String, FormatInformation> getFormatsInformation() {
		return formatsInformation;
	}
	
	
	public void addFormatsInformation(String format, FormatInformation info) {
		if(formatsInformation == null){
			formatsInformation = new HashMap<String,FormatInformation>();
		}
		formatsInformation.put(format, info);
	}
	
}