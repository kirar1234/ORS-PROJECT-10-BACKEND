package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ConfigurationDTO;

@Repository
public class ConfigurationDAOImpl extends BaseDAOImpl<ConfigurationDTO> implements ConfigurationDAOInt {

	@Override
	public Class<ConfigurationDTO> getDTOClass() {
		return ConfigurationDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ConfigurationDTO dto, CriteriaBuilder builder,
			Root<ConfigurationDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getConfigKey())) {

			whereCondition.add(builder.like(qRoot.get("configKey"), dto.getConfigKey()+ "%"));
		}
		return whereCondition;
	}

}
