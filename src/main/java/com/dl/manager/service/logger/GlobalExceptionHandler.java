package com.dl.manager.service.logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dl.manager.common.BackendResponse;
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
    public BackendResponse processError(ResourceNotFoundException e) {
        //return new Response(false, e.getMessage());
		return null;
    }
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BackendResponse processError(Exception e) {
        //return new Response(false, e.getMessage());
		return null;
    }



}
