package com.dl.manager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
import com.dl.manager.entity.provider.EntityProviderInterface;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol Jun 19, 2019
 *
 */
@Service
@Transactional
public class AccountService implements AccountServiceInterface {

	@Autowired
	private EntityProviderInterface entityProvider;

	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<BankAccount> getAllAccounts(Long communityId) throws ResourceNotFoundException {

		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		return repoContainer.getAccountRepo().findByCommunityId(communityFromDb.getId());
		
	}

	@Override
	public void createAccount(Long communityId, BankAccount account) throws ResourceNotFoundException {

		Community communityFromDb = entityProvider.getCommunityFromDb(communityId);
		account.setCommunity(communityFromDb);
		repoContainer.getAccountRepo().save(account);
		
	}

	@Override
	public void updateAccount(Long communityId, Long accountId, BankAccount account) throws ResourceNotFoundException, EntityValidationException {
		
		BankAccount accountFromDb = entityProvider.getAccountFromDb(communityId, accountId, account);
		accountFromDb.setAccountNumber(account.getAccountNumber());
		accountFromDb.setBankName(account.getBankName());
		repoContainer.getAccountRepo().save(accountFromDb);
		
	}

	@Override
	public void deleteAccount(Long communityId, Long accountId) throws ResourceNotFoundException {
		
		BankAccount accountFromDb = entityProvider.getAccountFromDb(communityId, accountId);
		repoContainer.getAccountRepo().delete(accountFromDb);
		
	}

}
