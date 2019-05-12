package com.dl.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.entity.Community;
import com.dl.manager.service.CommunityServiceInterface;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@RestController
@RequestMapping(value="")
public class CommunityController {
	
	@Autowired
	private CommunityServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/communities", method= RequestMethod.GET)
	public List<Community> getAllCommunities() {
		return service.getAllCommunities();
	}

}
