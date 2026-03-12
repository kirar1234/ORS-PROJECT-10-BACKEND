package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;

/**
 * BaseServiceImpl is a generic service implementation class.
 * 
 * It provides common business operations such as add, update, delete, find and
 * search.
 * 
 * This class works between Controller and DAO layer.
 * 
 * @author Amit
 *
 * @param <T> DTO class
 * @param <D> DAO class
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	/**
	 * DAO object used for database operations
	 */
	@Autowired
	protected D baseDao;

	/**
	 * Adds a new record in database.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 * @return generated primary key
	 */
	@Transactional(readOnly = false)
	public long add(T dto, UserContext userContext) {
		long pk = baseDao.add(dto, userContext);
		return pk;
	}

	/**
	 * Updates an existing record.
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) {

		T oldDto = baseDao.findByPK(dto.getId(), userContext);

		if (oldDto != null) {
			dto.setCreatedBy(oldDto.getCreatedBy());
			dto.setCreatedDatetime(oldDto.getCreatedDatetime());
		}

		baseDao.update(dto, userContext);
	}

	/**
	 * Saves a record (add or update).
	 * 
	 * @param dto         DTO object
	 * @param userContext logged in user
	 * @return record id
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) {

		Long id = dto.getId();

		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}

		return id;
	}

	/**
	 * Deletes a record by id.
	 * 
	 * @param id          primary key
	 * @param userContext logged in user
	 * @return deleted DTO
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) {

		T dto = findById(id, userContext);

		if (dto == null) {
			throw new DatabaseException("Record not found");
		}

		baseDao.delete(dto, userContext);

		return dto;
	}

	/**
	 * Finds record by id.
	 * 
	 * @param id          primary key
	 * @param userContext logged in user
	 * @return DTO object
	 */
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {

		T dto = baseDao.findByPK(id, userContext);

		return dto;
	}

	/**
	 * Finds record using unique attribute.
	 * 
	 * @param attribute   column name
	 * @param val         value
	 * @param userContext logged in user
	 * @return DTO object
	 */
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {

		T dto = baseDao.findByUniqueKey(attribute, val, userContext);

		return dto;
	}

	/**
	 * Searches records with pagination.
	 * 
	 * @param dto         search DTO
	 * @param pageNo      page number
	 * @param pageSize    page size
	 * @param userContext logged in user
	 * @return list of records
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {

		return baseDao.search(dto, pageNo, pageSize, userContext);
	}

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto         search DTO
	 * @param userContext logged in user
	 * @return list of records
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, UserContext userContext) {

		return baseDao.search(dto, userContext);
	}

}