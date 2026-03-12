package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DoctorDTO;

public class DoctorForm  extends BaseForm{
	
	@NotEmpty(message = "name is required")
	private String name;

	@NotNull(message = "appointmentdate is required")
	private Date appointmentdate;
	
	@NotEmpty(message = "mobile is required")
	private String mobile;
	
	@NotEmpty(message = "experties is required")
	private String experties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getExperties() {
		return experties;
	}

	public void setExperties(String experties) {
		this.experties = experties;
	}
	
	@Override
	public BaseDTO getDto() {
		DoctorDTO dto=initDTO(new DoctorDTO());
		dto.setName(name);
		dto.setAppointmentdate(appointmentdate);
		dto.setMobile(mobile);
		dto.setExperties(experties);
		return dto;
	}

}
