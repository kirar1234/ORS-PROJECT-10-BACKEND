package com.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

@Service
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt> implements MarksheetServiceInt{

	@Override
	public List<MarksheetDTO> getMeritList(UserContext context) {
		return baseDao.getMeritList();
	}

	@Override
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return baseDao.findByUniqueKey("rollNo", rollNo, context);
	}

}
	