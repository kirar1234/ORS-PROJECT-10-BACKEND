package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.LoanDTO;
import com.rays.form.LoanForm;
import com.rays.service.LoanServiceInt;

@RestController
@RequestMapping(value = "Loan")
public class LoanCtl extends BaseCtl<LoanForm, LoanDTO, LoanServiceInt> {

}
