package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VisitorDAOInt;
import com.rays.dto.VisitorDTO;

@Service
public class VisitorServiceImpl extends BaseServiceImpl<VisitorDTO, VisitorDAOInt> implements VisitorServiceInt {

}
