package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Community;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Service
public class CommunityService implements CommunityServiceInterface {
	
	private final static String NOT_FOUND_MESSAGE = "Stambena zajednica sa id=%s nije pronadjena!";
	
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
		
		Community communityFromDb = getCommunityFromDb(id);
		
		communityFromDb.setName(community.getName());
		communityFromDb.setIdentificationNumber(community.getIdentificationNumber());
		communityFromDb.setPib(community.getPib());
		
		repoContainer.getCommunityRepo().save(communityFromDb);
		
	}

	@Override
	public void deleteCommunity(Long id) throws ResourceNotFoundException {
		
		Community communityFromDb = getCommunityFromDb(id);
		
		repoContainer.getCommunityRepo().delete(communityFromDb);
		
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
