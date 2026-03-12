package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_configuration")
public class ConfigurationDTO extends BaseDTO {

	@Column(name = "ConfigKey")
	private String configKey;
	
	@Column(name = "ConfigValue")
	private String configValue;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "ConfigStatus")
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
	public String getUniqueKey() {
		return"configKey";
	}

	@Override
	public String getUniqueValue() {
		return configKey;
	}

	@Override
	public String getLabel() {
		return"config Key";
	}

	@Override
	public String getTableName() {
		return"Configuration";
	}
	
	
}
