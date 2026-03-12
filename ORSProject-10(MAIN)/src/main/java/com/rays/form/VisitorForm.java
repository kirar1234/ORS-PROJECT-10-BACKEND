package com.rays.form;

import java.time.LocalDateTime;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VisitorDTO;

public class VisitorForm extends BaseForm {

	
	@NotEmpty(message = "visitorPassCode is required")
	private String visitorPassCode;
	
	@NotEmpty(message = "visitorName is required")
	private String visitorName;
	
	@NotEmpty(message = "purpose is required")
	private String  purpose;
	
	@NotNull(message = "visitTime is required ")
	private LocalDateTime visitTime;
	
	@NotEmpty(message = "visitStatus is required")
	private  String visitStatus;

	public String getVisitorPassCode() {
		return visitorPassCode;
	}

	public void setVisitorPassCode(String visitorPassCode) {
		this.visitorPassCode = visitorPassCode;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public LocalDateTime getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(LocalDateTime visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}
	
	@Override
	public BaseDTO getDto() {
		VisitorDTO dto=initDTO(new VisitorDTO());
		
		dto.setVisitorPassCode(visitorPassCode);
		dto.setVisitorName(visitorName);
		dto.setPurpose(purpose);
		dto.setVisitTime(visitTime);
		dto.setVisitStatus(visitStatus);
		return dto;
	}
}
