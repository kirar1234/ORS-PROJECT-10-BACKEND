package com.rays.ctl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;

@RestController
@RequestMapping(value = "test")
public class TestCtl {
	
	@PostMapping("add")
	public ORSResponse add() {
		ORSResponse res = new ORSResponse();
		res.addData(null);
		res.addInputError("lastname is required");
		res.addMessage("user login successfully");
		res.addResult("lucky", 5);
		return res;
		
	}

}
