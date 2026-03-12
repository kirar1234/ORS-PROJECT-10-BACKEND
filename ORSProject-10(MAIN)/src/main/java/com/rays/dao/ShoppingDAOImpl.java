package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ShoppingDTO;

@Repository
public class ShoppingDAOImpl extends BaseDAOImpl<ShoppingDTO> implements ShoppingDAOInt {

	@Override
	public Class<ShoppingDTO> getDTOClass() {
		return ShoppingDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ShoppingDTO dto, CriteriaBuilder builder, Root<ShoppingDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getProductname())) {

			whereCondition.add(builder.like(qRoot.get("productname"), dto.getProductname() + "%"));
		}
		return whereCondition;
	}

}
