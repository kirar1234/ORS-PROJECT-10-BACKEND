package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BroadCastDAOInt;
import com.rays.dto.BroadCastDTO;

@Service
public class BroadCastServiceImpl extends BaseServiceImpl<BroadCastDTO, BroadCastDAOInt> implements BroadCastServiceInt {

}
