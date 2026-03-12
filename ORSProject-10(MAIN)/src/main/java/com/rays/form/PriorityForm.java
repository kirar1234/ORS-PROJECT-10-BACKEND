package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PriorityDTO;

public class PriorityForm extends BaseForm {

	@NotEmpty(message = "prioritycode is required")
	@Pattern(regexp = "^P\\d{3}$", message = "Priority code must be like P001")
	private String prioritycode;

	@NotEmpty(message = "prioritylevel is required")
	private String prioritylevel;

	@NotEmpty(message = "colortag is required")
	private String colortag;

	@NotEmpty(message = "prioritystatus is required")
	private String prioritystatus;

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
	
	@Override
	public BaseDTO getDto() {
		PriorityDTO dto=initDTO(new PriorityDTO());
		dto.setPrioritycode(prioritycode);
		dto.setPrioritylevel(prioritylevel);
		dto.setColortag(colortag);
		dto.setPrioritystatus(prioritystatus);
		return dto;
	}

}
