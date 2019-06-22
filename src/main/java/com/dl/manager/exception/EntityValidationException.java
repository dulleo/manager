package com.dl.manager.exception;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public class EntityValidationException extends Exception {

	private static final long serialVersionUID = 8030512826199473212L;
	
	public EntityValidationException() {
	}

	public EntityValidationException(String meesge) {
		super(meesge);
	}

}
