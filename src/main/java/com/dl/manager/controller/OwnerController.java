package com.dl.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.entity.Owner;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.OwnerServiceInterface;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@RestController
@RequestMapping(value="/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {
	
	@Autowired
	private OwnerServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/communities/{id}/owners", method= RequestMethod.GET)
	public List<Owner> getAllOwners(@PathVariable Long id) throws ResourceNotFoundException {
		return service.getAllOwners(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value="/communities/{id}/owners", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createOwner(@PathVariable Long id, @Valid @RequestBody Owner owner) throws ResourceNotFoundException {
		service.createOwner(id, owner);
	}
	
	@RequestMapping(value="/communities/{id}/owners/{ownerId}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateOwner(@PathVariable Long id, @PathVariable Long ownerId, @Valid @RequestBody Owner owner) throws ResourceNotFoundException, EntityValidationException {
		service.updateOwner(id, ownerId, owner);
	}
	
	@RequestMapping(value="/communities/{id}/owners/{ownerId}", method= RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteOwner(@PathVariable Long id, @PathVariable Long ownerId) throws ResourceNotFoundException {
		service.deleteOwner(id, ownerId);
	}

}
