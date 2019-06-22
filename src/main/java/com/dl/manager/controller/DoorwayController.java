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

import com.dl.manager.entity.Doorway;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.DoorwayServiceInterface;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@RestController
@RequestMapping(value="/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class DoorwayController {
	
	@Autowired
	private DoorwayServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/communities/{id}/doorways", method= RequestMethod.GET)
	public List<Doorway> getAllDoorways(@PathVariable Long id) throws ResourceNotFoundException {
		return service.getAllDoorways(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value="/communities/{id}/doorways", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createDoorway(@PathVariable Long id, @Valid @RequestBody Doorway doorway) throws ResourceNotFoundException {
		service.createDoorway(id, doorway);
	}
	
	@RequestMapping(value="/communities/{id}/doorways/{doorwayId}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateDoorway(@PathVariable Long id, @PathVariable Long doorwayId, @Valid @RequestBody Doorway doorway) throws ResourceNotFoundException, EntityValidationException {
		service.updateDoorway(id, doorwayId, doorway);
	}
	
	@RequestMapping(value="/communities/{id}/doorways/{doorwayId}", method= RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteDoorway(@PathVariable Long id, @PathVariable Long doorwayId) throws ResourceNotFoundException {
		service.deleteDoorway(id, doorwayId);
	}

}
