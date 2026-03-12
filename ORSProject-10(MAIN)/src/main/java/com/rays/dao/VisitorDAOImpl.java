package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VisitorDTO;


@Repository
public class VisitorDAOImpl extends BaseDAOImpl<VisitorDTO> implements VisitorDAOInt {

	@Override
	public Class<VisitorDTO> getDTOClass() {
	return VisitorDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(VisitorDTO dto, CriteriaBuilder builder, Root<VisitorDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getVisitorPassCode())) {

			whereCondition.add(builder.like(qRoot.get("visitorPassCode"), dto.getVisitorPassCode() + "%"));
		}
		return whereCondition;
	}

}
