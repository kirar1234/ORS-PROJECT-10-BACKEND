package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AccessLogDAOInt;
import com.rays.dto.AccessLogDTO;

@Service
@Transactional
public class AccessLogServiceImpl extends BaseServiceImpl<AccessLogDTO, AccessLogDAOInt> implements AccessLogServiceInt {

}
