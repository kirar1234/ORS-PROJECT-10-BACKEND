package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BankDTO;

@Repository
public class BankDAOImpl extends BaseDAOImpl<BankDTO> implements BankDAOInt {

	@Override
	public Class<BankDTO> getDTOClass() {
		return BankDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BankDTO dto, CriteriaBuilder builder, Root<BankDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getAccountCode())) {

			whereCondition.add(builder.like(qRoot.get("accountCode"), dto.getAccountCode() + "%"));
		}
		
		if (!isEmptyString(dto.getAccountHolderName())) {

			whereCondition.add(builder.like(qRoot.get("accountHolderName"), dto.getAccountHolderName() + "%"));
		}
		
		if (!isEmptyString(dto.getAccountType())) {

			whereCondition.add(builder.like(qRoot.get("accountType"), dto.getAccountType() + "%"));
		}
		return whereCondition;
	}

}
