package com.dl.manager.exception;

/**
 * 
 * @author duskol Jun 16, 2019
 *
 */
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -1859354838186276256L;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String meesge) {
		super(meesge);
	}
}
