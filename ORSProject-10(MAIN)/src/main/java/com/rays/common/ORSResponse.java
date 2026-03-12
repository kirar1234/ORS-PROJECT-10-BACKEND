package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ORSResponse is a common response class used to send API responses from
 * backend to frontend.
 * 
 * It contains response status and result data such as message, input errors,
 * and data.
 * 
 * This class helps to maintain a standard response format for all APIs.
 * 
 * Example response: { "success": true, "result": { "message": "Record added
 * successfully", "data": {...} } }
 * 
 * @author Amit
 */
public class ORSResponse {

	/**
	 * Constant key for input validation errors
	 */
	public static final String INPUT_ERROR = "inputerror";

	/**
	 * Constant key for response message
	 */
	public static final String MESSAGE = "message";

	/**
	 * Constant key for response data
	 */
	public static final String DATA = "data";

	/**
	 * Map to store response results like message, data, errors
	 */
	private Map<String, Object> result = new HashMap<String, Object>();

	/**
	 * Response status (true = success, false = failure)
	 */
	public boolean success = false;

	/**
	 * Default constructor
	 */
	public ORSResponse() {

	}

	/**
	 * Constructor with success status
	 * 
	 * @param success response status
	 */
	public ORSResponse(boolean success) {
		this.success = success;
	}

	/**
	 * Returns response status
	 * 
	 * @return success status
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets response status
	 * 
	 * @param success response status
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Returns result map
	 * 
	 * @return result map
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * Sets result map
	 * 
	 * @param result map of results
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * Adds input validation errors in response
	 * 
	 * @param value error details
	 */
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

	/**
	 * Adds message in response
	 * 
	 * @param value message text
	 */
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

	/**
	 * Adds data in response
	 * 
	 * @param value response data
	 */
	public void addData(Object value) {
		result.put(DATA, value);
	}

	/**
	 * Adds custom key-value pair in response
	 * 
	 * @param key   result key
	 * @param value result value
	 */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}

}