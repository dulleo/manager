package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Apartment;
import com.dl.manager.entity.Doorway;
import com.dl.manager.entity.provider.EntityProviderInterface;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
@Service
public class ApartmentService implements ApartmentServiceInterface {
	
	@Autowired
	private EntityProviderInterface entityProvider;
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Apartment> getAllApartments(Long communityId, Long doorwayId) throws ResourceNotFoundException {
		
		Doorway doorwayFromDb = entityProvider.getDoorwayFromDb(communityId, doorwayId);
		return repoContainer.getApartmentRepo().findByDoorwayId(doorwayFromDb.getId());
		
	}

	@Override
	public void createApartment(Long communityId, Long doorwayId, Apartment apartment) throws ResourceNotFoundException {
		
		Doorway doorwayFromDb = entityProvider.getDoorwayFromDb(communityId, doorwayId);
		apartment.setDoorway(doorwayFromDb);
		repoContainer.getApartmentRepo().save(apartment);
		
	}

}
