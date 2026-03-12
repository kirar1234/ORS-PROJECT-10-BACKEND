package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InvestorDTO;

@Repository
public class InvestorDAOImpl extends BaseDAOImpl<InvestorDTO> implements InvestorDAOInt {

	@Override
	public Class<InvestorDTO> getDTOClass() {
		return InvestorDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(InvestorDTO dto, CriteriaBuilder builder, Root<InvestorDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getInvestorName())) {

			whereCondition.add(builder.like(qRoot.get("investorName"), dto.getInvestorName() + "%"));
		}
		return whereCondition;
	}

}
