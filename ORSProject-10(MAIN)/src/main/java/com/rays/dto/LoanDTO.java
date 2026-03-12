package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_loan")
public class LoanDTO extends BaseDTO {

	@Column(name = "LoanName")
	private String loanName;

	@Column(name = "LaonAmount")
	private Double loanAmount;

	@Column(name = "InterestRate")
	private Double interestRate;

	@Column(name = "IssueDate")
	private Date issueDate;

	@Override
	public String getUniqueKey() {
		return "loanName";
	}

	@Override
	public String getUniqueValue() {
		return loanName;
	}

	@Override
	public String getLabel() {
		return "Loan Name";
	}

	@Override
	public String getTableName() {
		return "Loan";
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

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

}
