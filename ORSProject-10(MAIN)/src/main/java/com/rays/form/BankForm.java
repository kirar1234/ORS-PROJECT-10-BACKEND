package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BankDTO;

public class BankForm extends BaseForm {

	@NotEmpty(message = "account code is required")
	private String accountCode;

	@NotEmpty(message = "accountholder name is required")
	private String accountHolderName;

	@NotNull(message = "balance is required")
	private Double balance;


	@NotEmpty(message = "account type is required")
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
	public BaseDTO getDto() {
		BankDTO dto=initDTO(new BankDTO());
		dto.setAccountCode(accountCode);
		dto.setAccountHolderName(accountHolderName);
		dto.setBalance(balance);
		dto.setAccountType(accountType);
		return dto;
	}

}
