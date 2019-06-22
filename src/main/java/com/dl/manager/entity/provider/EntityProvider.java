package com.dl.manager.entity.provider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Component
public class EntityProvider implements EntityProviderInterface {
	
	private static String COMMUNITY_NOT_FOUND_MESSAGE = "Stambena zajednica id=%s nije pronadjena!";
	private static String ACCOUNT_NOT_FOUND_MESSAGE = "Za stambenu zajednicu id=%s nije pronadjen račun id=%s";
	private static String ID_INVALID_MESSAGE = "URL id=%s nije jednak sa id=%s";
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public Community getCommunityFromDb(Long id) throws ResourceNotFoundException {
		
		Optional<Community> communityOptional = repoContainer.getCommunityRepo().findById(id);

		if (!communityOptional.isPresent()) {
			throw new ResourceNotFoundException(String.format(COMMUNITY_NOT_FOUND_MESSAGE, id));
		}
		return communityOptional.get();
		
	}
	
	@Override
	public BankAccount getAccountFromDb(Long communityId, Long accountId) throws ResourceNotFoundException {
		
		BankAccount accountFromDb = repoContainer.getAccountRepo().findByIdAndCommunityId(accountId,communityId);
		
		if(accountFromDb == null) {
			throw new ResourceNotFoundException(String.format(ACCOUNT_NOT_FOUND_MESSAGE, communityId, accountId));
		}
		
		return accountFromDb;
	}

	@Override
	public BankAccount getAccountFromDb(Long communityId, Long accountId, BankAccount account) throws ResourceNotFoundException, EntityValidationException {
		
		if(accountId.longValue() != account.getId().longValue()) {
			throw new EntityValidationException(String.format(ID_INVALID_MESSAGE, accountId, account.getId()));
		}
		
		return this.getAccountFromDb(communityId, accountId);
	}

}
