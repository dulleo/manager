package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Community;
import com.dl.manager.entity.Owner;
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
public class OwnerService implements OwnerServiceInterface {
	
	@Autowired
	private EntityProviderInterface entityProvider;

	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Owner> getAllOwners(Long communityId) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		return repoContainer.getOwnerRepo().findByCommunityId(communityFromDb.getId());
		
	}

	@Override
	public void createOwner(Long communityId, Owner owner) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		owner.setCommunity(communityFromDb);
		repoContainer.getOwnerRepo().save(owner);
		
	}

	@Override
	public void updateOwner(Long communityId, Long ownerId, Owner owner) throws EntityValidationException, ResourceNotFoundException {
		
		Owner ownerFromDb = entityProvider.getOwnerFromDb(communityId, ownerId, owner);
		ownerFromDb.setFirstName(owner.getFirstName());
		ownerFromDb.setLastName(owner.getLastName());
		ownerFromDb.setPhone(owner.getPhone());
		ownerFromDb.setEmail(owner.getEmail());
		ownerFromDb.setStreet(owner.getStreet());
		ownerFromDb.setStreetNumber(owner.getStreetNumber());
		ownerFromDb.setCity(owner.getCity());
		repoContainer.getOwnerRepo().save(ownerFromDb);
		
	}

	@Override
	public void deleteOwner(Long communityId, Long ownerId) throws ResourceNotFoundException {
		
		Owner ownerFromDb = entityProvider.getOwnerFromDb(communityId, ownerId);
		repoContainer.getOwnerRepo().delete(ownerFromDb);
		
	}

}
