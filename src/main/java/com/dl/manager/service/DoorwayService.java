package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Community;
import com.dl.manager.entity.Doorway;
import com.dl.manager.entity.provider.EntityProviderInterface;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Service
public class DoorwayService implements DoorwayServiceInterface {
	
	@Autowired
	private EntityProviderInterface entityProvider;

	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Doorway> getAllDoorways(Long communityId) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		return repoContainer.getDoorwayRepo().findByCommunityId(communityFromDb.getId());
		
	}

	@Override
	public void createDoorway(Long communityId, Doorway doorway) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		doorway.setCommunity(communityFromDb);
		repoContainer.getDoorwayRepo().save(doorway);
		
	}

	@Override
	public void updateDoorway(Long communityId, Long doorwayId, Doorway doorway) throws EntityValidationException, ResourceNotFoundException {
		
		Doorway doorwayFromDb = entityProvider.getDoorwayFromDb(communityId, doorwayId, doorway);
		doorwayFromDb.setNumber(doorway.getNumber());
		repoContainer.getDoorwayRepo().save(doorwayFromDb);

	}

	@Override
	public void deleteDoorway(Long communityId, Long doorwayId) throws ResourceNotFoundException {
		
		Doorway doorwayFromDb = entityProvider.getDoorwayFromDb(communityId, doorwayId);
		repoContainer.getDoorwayRepo().delete(doorwayFromDb);

	}

}
