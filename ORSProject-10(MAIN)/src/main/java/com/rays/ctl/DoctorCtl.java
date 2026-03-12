package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.DoctorDTO;

import com.rays.form.DoctorForm;
import com.rays.service.DoctorServiceInt;


@RestController
@RequestMapping(value = "Doctor")
public class DoctorCtl extends BaseCtl<DoctorForm, DoctorDTO, DoctorServiceInt> {

	
	@Autowired
	private DoctorServiceInt doctorservice;
	
	
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse resp = new ORSResponse(true);

		List<DropdownList> doctorList = doctorservice.search(new DoctorDTO(), userContext);

		resp.addResult("doctorList", doctorList);

		return resp;
	}
}
