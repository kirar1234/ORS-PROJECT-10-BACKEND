package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InvestorDTO;

public class InvestorForm extends BaseForm {

	@NotEmpty(message = "investorName is required")
	private String investorName;

	@NotNull(message = "investmentAmount is required")
	private Double investmentAmount;

	@NotEmpty(message = "investmentType is required")
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
	public BaseDTO getDto() {
		InvestorDTO dto=initDTO(new InvestorDTO());
		dto.setInvestorName(investorName);
		dto.setInvestmentAmount(investmentAmount);
		dto.setInvestmentType(investmentType);
		return dto;
	}

}
