package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PolicyDTO;

public class PolicyForm extends BaseForm {

	@NotEmpty(message = "policy name is required")
	private String policyName;

	@NotNull(message = "premium amount is required")
	private Double premiumAmount;

	@NotNull(message = "start date is required")
	private Date startDate;

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public BaseDTO getDto() {
		PolicyDTO dto=initDTO(new PolicyDTO());
		
		dto.setPolicyName(policyName);
		dto.setPremiumAmount(premiumAmount);
		dto.setStartDate(startDate);
		return dto;
	}

}
