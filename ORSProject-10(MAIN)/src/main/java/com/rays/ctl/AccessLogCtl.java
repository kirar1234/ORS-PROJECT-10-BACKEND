package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.AccessLogDTO;
import com.rays.form.AccessLogForm;
import com.rays.service.AccessLogServiceInt;

@RestController
@RequestMapping(value = "Accesslog")
public class AccessLogCtl extends BaseCtl<AccessLogForm, AccessLogDTO, AccessLogServiceInt> {

}
