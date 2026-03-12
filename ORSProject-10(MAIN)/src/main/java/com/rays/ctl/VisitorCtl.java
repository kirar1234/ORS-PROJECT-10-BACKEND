
package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.VisitorDTO;
import com.rays.form.VisitorForm;
import com.rays.service.VisitorServiceInt;

@RestController
@RequestMapping(value = "Visitor")
public class VisitorCtl  extends BaseCtl<VisitorForm, VisitorDTO, VisitorServiceInt>{

}
