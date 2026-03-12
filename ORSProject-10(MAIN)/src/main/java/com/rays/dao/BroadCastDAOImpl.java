package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BroadCastDTO;

@Repository
public class BroadCastDAOImpl extends BaseDAOImpl<BroadCastDTO> implements BroadCastDAOInt {

	@Override
	public Class<BroadCastDTO> getDTOClass() {
		return BroadCastDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BroadCastDTO dto, CriteriaBuilder builder, Root<BroadCastDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBoardcastCode())) {

			whereCondition.add(builder.like(qRoot.get("boardcastCode"), dto.getBoardcastCode() + "%"));
		}
		return whereCondition;
	}

}
