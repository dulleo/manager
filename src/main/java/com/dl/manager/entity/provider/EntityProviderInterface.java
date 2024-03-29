package com.dl.manager.entity.provider;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
import com.dl.manager.entity.Doorway;
import com.dl.manager.entity.Owner;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public interface EntityProviderInterface {
	
	Community getCommunityFromDb(Long id) throws ResourceNotFoundException;

	BankAccount getAccountFromDb(Long communityId, Long accountId, BankAccount account) throws ResourceNotFoundException, EntityValidationException;

	BankAccount getAccountFromDb(Long communityId, Long accountId) throws ResourceNotFoundException;

	Doorway getDoorwayFromDb(Long communityId, Long doorwayId, Doorway doorway) throws EntityValidationException, ResourceNotFoundException;
	
	Doorway getDoorwayFromDb(Long communityId, Long doorwayId) throws ResourceNotFoundException;

	Owner getOwnerFromDb(Long communityId, Long ownerId, Owner owner) throws EntityValidationException, ResourceNotFoundException;
	
	Owner getOwnerFromDb(Long communityId, Long ownerId) throws ResourceNotFoundException;

}
