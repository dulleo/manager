package com.dl.manager.service;

import java.util.List;

import com.dl.manager.entity.Apartment;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
public interface ApartmentServiceInterface {

	List<Apartment> getAllApartments(Long communityId, Long doorwayId) throws ResourceNotFoundException;

	void createApartment(Long communityId, Long doorwayId, Apartment apartment) throws ResourceNotFoundException;

}
