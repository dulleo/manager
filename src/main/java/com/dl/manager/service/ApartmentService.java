package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Apartment;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
@Service
public class ApartmentService implements ApartmentServiceInterface {
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Apartment> getAllApartments() {
		
		List<Apartment> findAll = repoContainer.getApartmentRepo().findAll();
		
		return findAll;
		
	}

}
