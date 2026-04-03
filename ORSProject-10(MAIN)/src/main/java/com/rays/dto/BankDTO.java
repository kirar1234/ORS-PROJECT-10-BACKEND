package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_bank")
public class BankDTO extends BaseDTO {

	@Column(name = "AccountCode")
	private String accountCode;
	
	@Column(name = "AccountHolderName")
	private String accountHolderName;
	
	@Column(name = "Balance")
	private Double balance;
	
	@Column(name = "AccountType")
	private String accountType;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String getUniqueKey() {
		return"accountCode";
	}

	@Override
	public String getUniqueValue() {
		return accountCode;
	}

	@Override
	public String getLabel() {
		return "account code";
	}

	@Override
	public String getTableName() {
		return"Bank";
	}
	
	
}
