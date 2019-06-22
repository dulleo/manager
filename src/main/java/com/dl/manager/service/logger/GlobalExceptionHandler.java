package com.dl.manager.service.logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dl.manager.common.ErrorResponse;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;


/**
 * 
 * @author duskol Jun 17, 2019
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse processError(ResourceNotFoundException e) {
		return new ErrorResponse(e.getMessage());
		
    }
	
	@ExceptionHandler(EntityValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorResponse processError(EntityValidationException e) {
		return new ErrorResponse(e.getMessage());
		
    }
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse processError(Exception e) {
		return new ErrorResponse(e.getMessage());
    }



}
