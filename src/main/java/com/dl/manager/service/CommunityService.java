package com.dl.manager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Community;
import com.dl.manager.entity.provider.EntityProviderInterface;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Service
@Transactional
public class CommunityService implements CommunityServiceInterface {
	
	@Autowired
	private EntityProviderInterface entityProvider;
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Community> getAllCommunities() {
		
		return repoContainer.getCommunityRepo().findAll();
		
	}

	@Override
	public void createCommunity(Community community) {
		
		repoContainer.getCommunityRepo().save(community);
		
	}

	@Override
	public void updateCommunity(Long id, Community community) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(id);
		
		communityFromDb.setName(community.getName());
		communityFromDb.setIdentificationNumber(community.getIdentificationNumber());
		communityFromDb.setPib(community.getPib());
		
		repoContainer.getCommunityRepo().save(communityFromDb);
		
	}

	@Override
	public void deleteCommunity(Long id) throws ResourceNotFoundException {
		
		Community communityFromDb = entityProvider.getCommunityFromDb(id);
		repoContainer.getCommunityRepo().delete(communityFromDb);
		
	}
}
