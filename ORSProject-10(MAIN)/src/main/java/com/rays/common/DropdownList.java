package com.rays.common;

/**
 * DropdownList interface is used to provide data for dropdown fields.
 * 
 * Any DTO class that implements this interface can be used to populate dropdown
 * lists in UI.
 * 
 * It provides two methods: - getKey() : returns the unique identifier -
 * getValue() : returns the display value
 * 
 * Example: Role dropdown, User dropdown etc.
 * 
 * @author Amit
 */
public interface DropdownList {

	/**
	 * Returns the key value for dropdown option. Usually the primary key (id).
	 * 
	 * @return key value
	 */
	public String getKey();

	/**
	 * Returns the display value for dropdown option. This value is shown in the UI
	 * dropdown.
	 * 
	 * @return display value
	 */
	public String getValue();

}