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

import com.dl.manager.entity.Apartment;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.ApartmentServiceInterface;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
@RestController
@RequestMapping(value="/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ApartmentController {
	
	@Autowired
	private ApartmentServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/communities/{id}/doorways/{doorwayId}/apartments", method= RequestMethod.GET)
	public List<Apartment> getAllApartments(@PathVariable Long id, @PathVariable Long doorwayId) throws ResourceNotFoundException {
		return service.getAllApartments(id, doorwayId);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value="/communities/{id}/doorways/{doorwayId}/apartments", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createApartment(@PathVariable Long id, @PathVariable Long doorwayId, @Valid @RequestBody Apartment apartment) throws ResourceNotFoundException {
		service.createApartment(id, doorwayId, apartment);
	}

}
