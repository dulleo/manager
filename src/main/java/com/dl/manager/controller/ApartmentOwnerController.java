package com.dl.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.entity.dto.OwnerDTO;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.ApartmentOwnerInterface;

/**
 * 
 * @author duskol Jul 2, 2019
 *
 */
@RestController
@RequestMapping(value="/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ApartmentOwnerController {
	
	@Autowired
	private ApartmentOwnerInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/apartments/{apartmentId}/owners", method= RequestMethod.GET)
	public List<OwnerDTO> getOwnersForAccount(@PathVariable Long apartmentId) throws ResourceNotFoundException {
		return service.getOwnersForAccount(apartmentId);
	}

}
