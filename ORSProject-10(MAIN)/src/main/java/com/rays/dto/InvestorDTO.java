package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_investor")
public class InvestorDTO extends BaseDTO {

	@Column(name = "InvestorName")
	private String investorName;
	
	@Column(name = "InvestmentAmount")
	private Double investmentAmount;
	
	@Column(name = "InvestmentType")
	private String investmentType;

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public Double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(Double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	@Override
	public String getUniqueKey() {
		return"investorName";
	}

	@Override
	public String getUniqueValue() {
		return investorName;
	}

	@Override
	public String getLabel() {
		return"investor name";
	}

	@Override
	public String getTableName() {
		return"Investor";
	}
	
	
	
}
