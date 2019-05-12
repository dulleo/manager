package com.dl.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.manager.entity.Community;
import com.dl.manager.repository.RepositoryContainer;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Service
public class CommunityService implements CommunityServiceInterface {
	
	@Autowired
	private RepositoryContainer repoContainer;

	@Override
	public List<Community> getAllCommunities() {
		
		return repoContainer.getCommunityRepo().findAll();
		
	}

}
