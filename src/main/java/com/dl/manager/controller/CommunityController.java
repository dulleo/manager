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

import com.dl.manager.entity.Community;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.CommunityServiceInterface;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@RestController
@RequestMapping(value="/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class CommunityController {
	
	@Autowired
	private CommunityServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/communities", method= RequestMethod.GET)
	public List<Community> getAllCommunities() {
		return service.getAllCommunities();
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value="/communities", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createCommunity(@Valid @RequestBody Community community) {
		service.createCommunity(community);
	}
	
	@RequestMapping(value="/communities/{id}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateCommunity(@PathVariable Long id, @Valid @RequestBody Community community) throws ResourceNotFoundException {
		service.updateCommunity(id, community);
	}
	
	@RequestMapping(value="/communities/{id}", method= RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCommunity(@PathVariable Long id) throws ResourceNotFoundException {
		service.deleteCommunity(id);
	}

}
