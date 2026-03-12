package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * BaseDAOImpl is a generic DAO implementation that provides common database
 * operations using JPA EntityManager.
 *
 * It contains generic CRUD methods such as: Add, Update, Delete, Find by PK,
 * Search etc.
 *
 * @author Amit
 *
 * @param <T> DTO class that extends BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	/**
	 * EntityManager used for database operations.
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Returns DTO class type.
	 * 
	 * @return DTO class
	 */
	public abstract Class<T> getDTOClass();

	/**
	 * Creates where clause predicates for search criteria.
	 * 
	 * @param dto     DTO object containing search parameters
	 * @param builder CriteriaBuilder
	 * @param qRoot   Root object
	 * @return List of predicates
	 */
	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	/**
	 * Populate additional fields before saving or updating data.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user context
	 */
	protected void populate(T dto, UserContext userContext) {
	}

	/**
	 * Returns top 10 records for marksheet merit list.
	 * 
	 * @param hql         HQL query
	 * @param userContext logged in user
	 * @return List of merit records
	 */
	public List marksheetMeritList(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List l = q.getResultList();
		return l;
	}

	/**
	 * Adds new record into database.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 * @return generated primary key
	 */
	@Override
	public long add(T dto, UserContext userContext) {
		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	/**
	 * Updates existing record.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 */
	@Override
	public void update(T dto, UserContext userContext) {
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);

	}

	/**
	 * Deletes record from database.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 */
	@Override
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);

	}

	/**
	 * Finds record by primary key.
	 * 
	 * @param pk          primary key
	 * @param userContext logged in user
	 * @return DTO object
	 */
	@Override
	public T findByPK(long pk, UserContext userContext) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	/**
	 * Finds record using unique attribute.
	 * 
	 * @param attribute   column name
	 * @param val         value of attribute
	 * @param userContext logged in user
	 * @return DTO object
	 */
	@Override
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;
	}

	/**
	 * Creates criteria query for searching records.
	 * 
	 * @param dto         DTO containing search fields
	 * @param userContext logged in user
	 * @return TypedQuery object
	 */
	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());

		Root<T> qRoot = cq.from(getDTOClass());

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		return query;
	}

	/**
	 * Search records with pagination.
	 * 
	 * @param dto         search DTO
	 * @param pageNo      page number
	 * @param pageSize    page size
	 * @param userContext logged in user
	 * @return list of records
	 */
	@Override
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		TypedQuery<T> query = createCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		return list;
	}

	/**
	 * Search all records without pagination.
	 * 
	 * @param dto         search DTO
	 * @param userContext logged in user
	 * @return list of records
	 */
	@Override
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Check if string is empty.
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Check if double value is zero.
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Check if long value is zero.
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Check if integer value is zero.
	 */
	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	/**
	 * Check if object is not null.
	 */
	protected boolean isNotNull(Object val) {
		return val != null;
	}

}