package com.rays.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AccessLogDTO;

@Repository
public class AccessLogDAOImpl extends BaseDAOImpl<AccessLogDTO> implements AccessLogDAOInt{

	@Override
	public Class<AccessLogDTO> getDTOClass() {
		return AccessLogDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(AccessLogDTO dto, CriteriaBuilder builder, Root<AccessLogDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getAccessReferenceId())) {

			whereCondition.add(builder.like(qRoot.get("accessReferenceId"), dto.getAccessReferenceId() + "%"));
		}
		return whereCondition;
	}

}
