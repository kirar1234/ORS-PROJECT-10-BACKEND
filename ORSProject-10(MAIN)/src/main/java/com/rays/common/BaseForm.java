package com.rays.common;

/**
 * BaseForm is the parent form class for all form classes.
 * 
 * It contains common fields used in forms such as id, createdBy, modifiedBy,
 * createdDatetime and modifiedDatetime.
 * 
 * All form classes extend this class and convert form data into DTO objects.
 * 
 * @author Amit
 */
public class BaseForm {

	/**
	 * Primary key of the record
	 */
	protected Long id;

	/**
	 * User who created the record
	 */
	protected String createdBy;

	/**
	 * User who modified the record
	 */
	protected String modifiedBy;

	/**
	 * Record creation time
	 */
	protected long createdDatetime;

	/**
	 * Record modification time
	 */
	protected long modifiedDatetime;

	/**
	 * Array of ids used for multiple delete operations
	 */
	private Long[] ids;

	/**
	 * Page number used in pagination
	 */
	private int pageNo = 0;

	/**
	 * Page size used in pagination
	 */
	private int pageSize = 5;

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
	 * Converts form data to DTO object.
	 * 
	 * Subclasses override this method to populate DTO fields.
	 * 
	 * @return BaseDTO object
	 */
	public BaseDTO getDto() {
		return null;
	}

	/**
	 * Initializes DTO with form id value.
	 * 
	 * @param dto DTO object
	 * @return initialized DTO
	 */
	public <T extends BaseDTO> T initDTO(T dto) {

		if (id != null && id > 0) {
			dto.setId(id);
		} else {
			dto.setId(null);
		}
		return dto;

	}
}