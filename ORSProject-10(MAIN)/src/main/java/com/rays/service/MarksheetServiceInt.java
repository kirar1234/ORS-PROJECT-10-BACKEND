package com.rays.service;

import java.util.List;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {

	
	public List<MarksheetDTO> getMeritList(UserContext context);
	
	public MarksheetDTO findByRollNo(String rollNo, UserContext context);
}
