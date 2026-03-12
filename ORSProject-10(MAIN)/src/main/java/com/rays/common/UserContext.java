package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * UserContext class stores information about the logged-in user.
 * 
 * It is mainly used to maintain user session details such as: userId, loginId,
 * name, roleId and roleName.
 * 
 * This object is stored in HTTP Session after login and is used across the
 * application for authentication and authorization.
 * 
 * Example use: - Tracking who created or modified a record - Checking user role
 * and permissions
 * 
 * @author Amit
 */
public class UserContext {

	/**
	 * Logged-in user id
	 */
	private Long userId = 0L;

	/**
	 * Logged-in user login id (email)
	 */
	private String loginId = "root";

	/**
	 * Logged-in user name
	 */
	private String name = null;

	/**
	 * Role id of logged-in user
	 */
	private Long roleId = 0L;

	/**
	 * Role name of logged-in user
	 */
	private String roleName = "root";

	/**
	 * Complete UserDTO object
	 */
	private UserDTO userDTO = null;

	/**
	 * Default constructor
	 */
	public UserContext() {
	}

	/**
	 * Parameterized constructor.
	 * 
	 * It initializes UserContext using UserDTO object.
	 * 
	 * @param dto UserDTO object
	 */
	public UserContext(UserDTO dto) {
		this.userDTO = dto;
		this.userId = dto.getId();
		this.loginId = dto.getLoginId();
		this.name = dto.getName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	/**
	 * Returns user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Returns login id
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets login id
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Returns user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets user name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns role id
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets role id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Returns role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Returns UserDTO object
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Sets UserDTO object
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}