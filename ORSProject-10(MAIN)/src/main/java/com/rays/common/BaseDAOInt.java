package com.rays.common;

import java.util.List;

/**
 * BaseDAOInt is a generic DAO interface.
 * 
 * It defines common database operations such as add, update, delete, find and
 * search.
 * 
 * All DAO classes will implement this interface.
 * 
 * @author Amit
 *
 * @param <T> DTO class that extends BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/**
	 * Adds a new record in database.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user context
	 * @return generated primary key
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing record.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user context
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Deletes a record from database.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user context
	 */
	public void delete(T dto, UserContext userContext);

	/**
	 * Finds record by primary key.
	 * 
	 * @param pk          primary key
	 * @param userContext logged in user context
	 * @return DTO object
	 */
	public T findByPK(long pk, UserContext userContext);

	/**
	 * Finds record using unique attribute.
	 * 
	 * @param attribute   column name
	 * @param val         value of column
	 * @param userContext logged in user context
	 * @return DTO object
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext);

	/**
	 * Searches records with pagination.
	 * 
	 * @param dto         search DTO
	 * @param pageNo      page number
	 * @param pageSize    page size
	 * @param userContext logged in user context
	 * @return list of records
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto         search DTO
	 * @param userContext logged in user context
	 * @return list of records
	 */
	public List search(T dto, UserContext userContext);

}