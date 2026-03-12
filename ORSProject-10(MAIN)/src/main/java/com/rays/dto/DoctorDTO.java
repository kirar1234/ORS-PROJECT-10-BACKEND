package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_doctor")
public class DoctorDTO extends BaseDTO {

	@Column(name = "NAME")
	private String name;

	@Column(name = "APPOINTMENTDATE")
	private Date appointmentdate;

	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EXPERTIES")
	private String experties;

	@Override
	public String getUniqueKey() {
		return"mobile";
	}

	@Override
	public String getUniqueValue() {
		return mobile;
	}

	@Override
	public String getLabel() {
		return"mobile no";
	}

	@Override
	public String getTableName() {
		return"doctor";
	}

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
	public String getValue() {
		return experties;
	}
	
	
	

}
