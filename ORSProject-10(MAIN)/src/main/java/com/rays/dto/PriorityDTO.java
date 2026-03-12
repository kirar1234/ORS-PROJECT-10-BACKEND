package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_priority")
public class PriorityDTO extends BaseDTO{

	@Column(name = "Prioritycode")
	private String prioritycode;
	
	@Column(name = "Prioritylevel")
	private String prioritylevel;
	
	@Column(name = "Colortag")
	private String colortag;
	
	@Column(name = "Prioritystatus")
	private String prioritystatus;

	@Override
	public String getUniqueKey() {
		return"prioritycode";
	}

	@Override
	public String getUniqueValue() {
		return prioritycode;
	}

	@Override
	public String getLabel() {
		return "priority code";
	}

	@Override
	public String getTableName() {
		return"priority";
	}

	public String getPrioritycode() {
		return prioritycode;
	}

	public void setPrioritycode(String prioritycode) {
		this.prioritycode = prioritycode;
	}

	public String getPrioritylevel() {
		return prioritylevel;
	}

	public void setPrioritylevel(String prioritylevel) {
		this.prioritylevel = prioritylevel;
	}

	public String getColortag() {
		return colortag;
	}

	public void setColortag(String colortag) {
		this.colortag = colortag;
	}

	public String getPrioritystatus() {
		return prioritystatus;
	}

	public void setPrioritystatus(String prioritystatus) {
		this.prioritystatus = prioritystatus;
	}
	
	
	
	
}
