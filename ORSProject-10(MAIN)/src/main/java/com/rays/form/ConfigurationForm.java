package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ConfigurationDTO;

public class ConfigurationForm  extends BaseForm{

	@NotEmpty(message = "configKey is required")
	private String configKey;
	
	@NotEmpty(message = "configValue is required")
	private String configValue;
	
	@NotEmpty(message = "description is required")
	private String description;
	
	@NotEmpty(message = "configStatus is required")
	private String configStatus;

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConfigStatus() {
		return configStatus;
	}

	public void setConfigStatus(String configStatus) {
		this.configStatus = configStatus;
	}
	
	@Override
	public BaseDTO getDto() {
		ConfigurationDTO dto=initDTO(new ConfigurationDTO());
		
		dto.setConfigKey(configKey);
		dto.setConfigValue(configValue);
		dto.setDescription(description);
		dto.setConfigStatus(configStatus);
		return dto;
		
	}
}
