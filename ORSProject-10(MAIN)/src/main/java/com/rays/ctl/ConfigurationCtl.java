package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ConfigurationDTO;
import com.rays.form.ConfigurationForm;
import com.rays.service.ConfigurationServiceInt;

@RestController
@RequestMapping(value = "Configuration")
public class ConfigurationCtl extends BaseCtl<ConfigurationForm, ConfigurationDTO, ConfigurationServiceInt> {

}
