package com.dl.manager.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Component
public class RepositoryContainer {
	
	@Autowired
	private CommunityRepository communityRepo;
	
	@Autowired
	private AccountRepository accountRepo;

	public CommunityRepository getCommunityRepo() {
		return communityRepo;
	}

	public AccountRepository getAccountRepo() {
		return accountRepo;
	}
	
	
	
}