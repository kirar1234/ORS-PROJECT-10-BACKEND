package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ConfigurationDAOInt;
import com.rays.dto.ConfigurationDTO;

@Service
public class ConfigurationServiceImpl extends BaseServiceImpl<ConfigurationDTO,ConfigurationDAOInt> implements ConfigurationServiceInt {

}
