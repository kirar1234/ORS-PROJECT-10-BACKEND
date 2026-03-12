package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_report")
public class ReportDTO extends BaseDTO {
	
	
	@Column(name = "report_id")
	private long reportId;
	
	@Column(name = "report_name", length = 50)
	private String reportName;
	
	@Column(name = "generated_date")
	private Date generatedDate;
	
	@Column(name = "generated_by", length = 50)
	private String generatedBy;
	
	@Column(name = "report_status", length = 50)
	private String reportStatus;
	

	@Override
	public String getUniqueKey() {
		return"reportName";
	}

	@Override
	public String getUniqueValue() {
		return reportName;
	}

	@Override
	public String getLabel() {
		return"report name";
	}

	@Override
	public String getTableName() {
		return"report";
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	
	

	
	
}
