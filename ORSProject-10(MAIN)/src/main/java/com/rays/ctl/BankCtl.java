package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.BankDTO;
import com.rays.form.BankForm;
import com.rays.service.BankServiceInt;

@RestController
@RequestMapping(value = "Bank")
public class BankCtl extends BaseCtl<BankForm, BankDTO, BankServiceInt> {

}
