package com.dl.manager.service;

import java.util.List;

import com.dl.manager.entity.Community;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
public interface CommunityServiceInterface {

	List<Community> getAllCommunities();

	void createCommunity(Community community);

	void updateCommunity(Long id, Community community) throws ResourceNotFoundException;

	void deleteCommunity(Long id) throws ResourceNotFoundException;

}
