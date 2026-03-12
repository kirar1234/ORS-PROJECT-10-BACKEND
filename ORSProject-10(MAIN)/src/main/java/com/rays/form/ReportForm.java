package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ReportDTO;

public class ReportForm extends BaseForm {

	@NotNull(message = "reportid is required")
	@Min(1)
	private long reportId;

	@NotEmpty(message = "reportname is required")
	private String reportName;

	@NotNull(message = "Date of birth is required")
	private Date generatedDate;

	@NotEmpty(message = "generatedBy is required")
	private String generatedBy;

	@NotEmpty(message = "reportStatus is required")
	private String reportStatus;

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

	@Override
	public BaseDTO getDto() {
		ReportDTO dto = initDTO(new ReportDTO());

		dto.setReportId(reportId);
		dto.setReportName(reportName);
		dto.setGeneratedDate(generatedDate);
		dto.setGeneratedBy(generatedBy);
		dto.setReportStatus(reportStatus);
		return dto;

	}

}
