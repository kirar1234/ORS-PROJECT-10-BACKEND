package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.LoanDAOInt;
import com.rays.dto.LoanDTO;

@Service
public class LoanServiceImpl extends BaseServiceImpl<LoanDTO, LoanDAOInt> implements LoanServiceInt{

}
