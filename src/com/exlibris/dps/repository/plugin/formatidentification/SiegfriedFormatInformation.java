package com.exlibris.dps.repository.plugin.formatidentification;

import com.exlibris.core.sdk.consts.Enum.FormatIdentificationMethod;
import com.exlibris.dps.sdk.formatidentification.FormatInformation;


public class SiegfriedFormatInformation implements FormatInformation{
	
	private String formatId;
	private String warning;
	private FormatIdentificationMethod identificationMethod;
	private String identificationMethodDetails;
	
	public void setFormatId(String formatId) {
		// TODO Auto-generated method stub
		this.formatId = formatId;
	}
	
	@Override
	public String getFormatId() {
		// TODO Auto-generated method stub
		return this.formatId;
	}

	@Override
	public FormatIdentificationMethod getIdentificationMethod() {
		// TODO Auto-generated method stub
		return this.identificationMethod;
	}
	
	public void setIdentificationMethod(FormatIdentificationMethod identificationMethod) {
		// TODO Auto-generated method stub
		this.identificationMethod = identificationMethod;
	}

	@Override
	public String getIdentificationMethodDetails() {
		// TODO Auto-generated method stub
		return this.identificationMethodDetails;
	}
	
	public void setIdentificationMethodDetails(String identificationMethodDetails) {
		this.identificationMethodDetails = identificationMethodDetails;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	@Override
	public String getWarning() {
		// TODO Auto-generated method stub
		return this.warning;
	}
	

}
