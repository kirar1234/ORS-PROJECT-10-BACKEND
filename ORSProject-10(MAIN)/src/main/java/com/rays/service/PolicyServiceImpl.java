package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PolicyDAOInt;
import com.rays.dto.PolicyDTO;

@Service
public class PolicyServiceImpl extends BaseServiceImpl<PolicyDTO, PolicyDAOInt> implements PolicyServiceInt {

}
