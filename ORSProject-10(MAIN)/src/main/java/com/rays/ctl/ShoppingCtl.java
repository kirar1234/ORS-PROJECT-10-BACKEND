package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ShoppingDTO;
import com.rays.form.ShoppingForm;
import com.rays.service.ShoppingServiceInt;

@RestController
@RequestMapping(value = "Shopping")
public class ShoppingCtl  extends BaseCtl<ShoppingForm, ShoppingDTO, ShoppingServiceInt>{

}
