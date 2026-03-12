package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.InvestorDTO;
import com.rays.form.InvestorForm;
import com.rays.service.InvestorServiceInt;

@RestController
@RequestMapping(value = "Investor")
public class InvestorCtl extends BaseCtl<InvestorForm, InvestorDTO, InvestorServiceInt> {

}
