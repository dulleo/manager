package com.dl.manager.entity.provider;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
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

}
