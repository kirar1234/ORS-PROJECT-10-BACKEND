package com.rays.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AccessLogDTO;

public class AccessLogForm extends BaseForm {

	@NotEmpty(message = "accessReferenceId is required")
	private String accessReferenceId;

	@NotEmpty(message = "accessType is required")
	private String accessType;

	@NotNull(message = "accessTime is required")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime accessTime;

	@NotEmpty(message = "accessStatus is required")
	private String accessStatus;

	public String getAccessReferenceId() {
		return accessReferenceId;
	}

	public void setAccessReferenceId(String accessReferenceId) {
		this.accessReferenceId = accessReferenceId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public LocalDateTime getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(LocalDateTime accessTime) {
		this.accessTime = accessTime;
	}

	public String getAccessStatus() {
		return accessStatus;
	}

	public void setAccessStatus(String accessStatus) {
		this.accessStatus = accessStatus;
	}
	
	@Override
	public BaseDTO getDto() {
		AccessLogDTO dto=initDTO(new AccessLogDTO());
		dto.setAccessReferenceId(accessReferenceId);
		dto.setAccessType(accessType);
		dto.setAccessTime(accessTime);
		dto.setAccessStatus(accessStatus);
		return dto;
		
	}

}
