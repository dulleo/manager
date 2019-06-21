package com.dl.manager.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
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
	
	private final static String NOT_FOUND_MESSAGE = "Stambena zajednica sa id=%s nije pronadjena!";
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<BankAccount> getAllAccounts(Long id) throws ResourceNotFoundException {
		
		Community communityFromDb = getCommunityFromDb(id);
		
		return repoContainer.getAccountRepo().findByCommunityId(communityFromDb.getId());
	}
	
	@Override
	public void createAccount(Long id, @Valid BankAccount account) throws ResourceNotFoundException {
		
		Community communityFromDb = getCommunityFromDb(id);
		
		account.setCommunity(communityFromDb);
		
		repoContainer.getAccountRepo().save(account);
	}
	
	@Override
	public void updateAccount(Long id, Long accountId, BankAccount account) {
		
		getAccountFromDb(id, accountId);
		
	}

	/**
	 * 
	 * @param id
	 * @param accountId
	 */
	private BankAccount getAccountFromDb(Long id, Long accountId) {
		
		//return repoContainer.getAccountRepo().findById(accountId)
			//.orElseThrow(()-> new ResourceNotFoundException(String.format("Ne postoji račun id: %s za stambenu zajednicu id: %s", accountId, id)));
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	private Community getCommunityFromDb(Long id) throws ResourceNotFoundException {
		Community communityFromDb = repoContainer.getCommunityRepo().findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(String.format(NOT_FOUND_MESSAGE, id)));
		return communityFromDb;
	}

}
