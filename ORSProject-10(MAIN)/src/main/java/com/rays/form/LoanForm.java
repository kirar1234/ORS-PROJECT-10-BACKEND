package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LoanDTO;

public class LoanForm extends BaseForm {

	@NotEmpty(message = "loanname is required")
	private String loanName;

	@NotNull(message = "loanamount is required")
	private Double loanAmount;

	@NotNull(message = "interest is required")
	private Double interestRate;

	@NotNull(message = "issuedate is required")
	private Date issueDate;

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Override
	public BaseDTO getDto() {
		LoanDTO dto=initDTO(new LoanDTO());
		
		dto.setLoanName(loanName);
		dto.setLoanAmount(loanAmount);
		dto.setInterestRate(interestRate);
		dto.setIssueDate(issueDate);
		return dto;
	}

}
