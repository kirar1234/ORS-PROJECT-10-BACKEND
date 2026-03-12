package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_policy")
public class PolicyDTO extends BaseDTO {

	@Column(name = "PolicyName")
	private String policyName;

	@Column(name = "PremiumAmount")
	private Double premiumAmount;

	@Column(name = "StartDate")
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
	public String getUniqueKey() {
		return"policyName";
	}

	@Override
	public String getUniqueValue() {
		return policyName;
	}

	@Override
	public String getLabel() {
		return"Policy Name";
	}

	@Override
	public String getTableName() {
		return"Policy";
	}

}
