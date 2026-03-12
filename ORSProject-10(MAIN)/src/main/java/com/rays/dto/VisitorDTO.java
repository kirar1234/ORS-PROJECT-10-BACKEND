package com.rays.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_visitor")
public class VisitorDTO extends BaseDTO {

	@Column(name = "VisitorPassCode")
	private String visitorPassCode;
	
	@Column(name = "VisitorName")
	private String visitorName;
	
	@Column(name = "Purpose")
	private String  purpose;
	
	@Column(name = "VisitTime")
	private LocalDateTime visitTime;
	
	@Column(name = "VisitStatus")
	private  String visitStatus;

	@Override
	public String getUniqueKey() {
		return"visitorPassCode";
	}

	@Override
	public String getUniqueValue() {
		return visitorPassCode;
	}

	@Override
	public String getLabel() {
		return"visitorPass Code";
	}

	@Override
	public String getTableName() {
		return"Visitor";
	}

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
	
	
	
	
}
