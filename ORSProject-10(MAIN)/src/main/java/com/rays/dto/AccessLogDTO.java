package com.rays.dto;





import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_accesslog")
public class AccessLogDTO extends BaseDTO {

	
	@Column(name = "AccessReferenceId")
	private String accessReferenceId;
	
	@Column(name = "AccessType")
	private String accessType;
	
	@Column(name = "AccessTime")
	private LocalDateTime accessTime;
	
	@Column(name = "AccessStatus")
	private String accessStatus;

	@Override
	public String getUniqueKey() {
		return"accessReferenceId";
	}

	@Override
	public String getUniqueValue() {
		return accessReferenceId;
	}

	@Override
	public String getLabel() {
		return "accessReference Id";
	}

	@Override
	public String getTableName() {
		return "Accesslog";
	}

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
	
	
	
	
	
	
}
