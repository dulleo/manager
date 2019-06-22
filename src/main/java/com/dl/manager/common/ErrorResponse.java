package com.dl.manager.common;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public class ErrorResponse {

	private String message;
	
	public ErrorResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
