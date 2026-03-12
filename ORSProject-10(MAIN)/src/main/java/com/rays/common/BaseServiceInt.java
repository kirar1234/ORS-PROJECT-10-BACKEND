package com.rays.common;

import java.util.List;

/**
 * BaseServiceInt is a generic service interface.
 * 
 * It defines common business operations that will be implemented by the Service
 * layer.
 * 
 * These operations are used for CRUD and search functionality.
 * 
 * @author Amit
 *
 * @param <T> DTO class
 */
public interface BaseServiceInt<T extends BaseDTO> {

	/**
	 * Adds a new record.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user information
	 * @return generated primary key
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing record.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user information
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Saves record (Add or Update).
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user information
	 * @return record id
	 */
	public long save(T dto, UserContext userContext);

	/**
	 * Deletes record by id.
	 * 
	 * @param id          primary key
	 * @param userContext logged in user information
	 * @return deleted DTO
	 */
	public T delete(long id, UserContext userContext);

	/**
	 * Finds record by primary key.
	 * 
	 * @param id          primary key
	 * @param userContext logged in user information
	 * @return DTO object
	 */
	public T findById(long id, UserContext userContext);

	/**
	 * Finds record using unique attribute.
	 * 
	 * @param attribute   column name
	 * @param val         value
	 * @param userContext logged in user information
	 * @return DTO object
	 */
	public T findByUniqueKey(String attribute, String val, UserContext userContext);

	/**
	 * Searches records with pagination.
	 * 
	 * @param dto         search DTO
	 * @param pageNo      page number
	 * @param pageSize    page size
	 * @param userContext logged in user information
	 * @return list of records
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto         search DTO
	 * @param userContext logged in user information
	 * @return list of records
	 */
	public List search(T dto, UserContext userContext);

}