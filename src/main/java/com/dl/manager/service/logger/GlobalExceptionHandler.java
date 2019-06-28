package com.dl.manager.service.logger;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dl.manager.common.ErrorResponse;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;

/**
 * 
 * @author duskol Jun 17, 2019
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody 
    public ErrorResponse processError(DataIntegrityViolationException e) {
		
		String errorMessage = "";
		
		if(e.getCause().getCause() != null && e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
			errorMessage = e.getCause().getCause().getMessage();
		} else {
			errorMessage = e.getMessage();
		}
		return new ErrorResponse(errorMessage);
    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody 
    public ErrorResponse processError(ResourceNotFoundException e) {
		return new ErrorResponse(e.getMessage());
    }
	
	@ExceptionHandler(EntityValidationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse processError(EntityValidationException e) {
		return new ErrorResponse(e.getMessage());
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
	public ErrorResponse processError(MethodArgumentNotValidException ex) {
		
		StringBuilder sb = new StringBuilder();
		BindingResult bindingResult = ex.getBindingResult();
		
		bindingResult.getAllErrors().stream().forEach(e-> {
			sb.append(e.getDefaultMessage()).append(";");
		});
		
		String errorMessage = sb.toString().substring(0, sb.toString().length() - 1);
		return new ErrorResponse(errorMessage);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
	public ErrorResponse handleBindingErrors(HttpMessageNotReadableException ex) {
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse processError(Exception e) {
		return new ErrorResponse(e.getMessage());
    }
}
