package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DoctorDAOInt;
import com.rays.dto.DoctorDTO;

@Service
public class DoctorServiceImpl extends BaseServiceImpl<DoctorDTO, DoctorDAOInt> implements DoctorServiceInt {

}
