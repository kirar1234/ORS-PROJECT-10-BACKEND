package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * BaseDTO is the parent class for all DTO classes.
 * 
 * It contains common fields used in all entities such as: id, createdBy,
 * modifiedBy, createdDatetime and modifiedDatetime.
 * 
 * All DTO classes in the application extend this class.
 * 
 * It also provides common methods used for unique validation and dropdown list
 * values.
 * 
 * @author Amit
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

	/**
	 * Primary key of the table
	 */
	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;

	/**
	 * User who created the record
	 */
	@Column(name = "created_by", length = 50)
	protected String createdBy = "root";

	/**
	 * User who modified the record
	 */
	@Column(name = "modified_by", length = 50)
	protected String modifiedBy = "root";

	/**
	 * Record creation date and time
	 */
	@Column(name = "created_datetime")
	protected Timestamp createdDatetime;

	/**
	 * Record modification date and time
	 */
	@Column(name = "modified_datetime")
	protected Timestamp modifiedDatetime;

	/**
	 * Gets id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id primary key
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets createdBy
	 * 
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets createdBy
	 * 
	 * @param createdBy user who created the record
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets modifiedBy
	 * 
	 * @return modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets modifiedBy
	 * 
	 * @param modifiedBy user who modified the record
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets createdDatetime
	 * 
	 * @return createdDatetime
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * Sets createdDatetime
	 * 
	 * @param createdDatetime creation timestamp
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Gets modifiedDatetime
	 * 
	 * @return modifiedDatetime
	 */
	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	/**
	 * Sets modifiedDatetime
	 * 
	 * @param modifiedDatetime modification timestamp
	 */
	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Returns the unique key column name
	 * 
	 * @return column name
	 */
	public abstract String getUniqueKey();

	/**
	 * Returns the value of unique field
	 * 
	 * @return unique value
	 */
	public abstract String getUniqueValue();

	/**
	 * Returns label name for error messages
	 * 
	 * @return label
	 */
	public abstract String getLabel();

	/**
	 * Returns table name
	 * 
	 * @return table name
	 */
	public abstract String getTableName();

	/**
	 * Returns key value for dropdown list
	 */
	@Override
	public String getKey() {
		return id + "";
	}

	/**
	 * Returns value for dropdown list
	 */
	@Override
	public String getValue() {
		return null;
	}

}