package com.dl.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dl.manager.entity.Owner;
import com.dl.manager.exception.EntityValidationException;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Service
public interface OwnerServiceInterface {

	List<Owner> getAllOwners(Long communityId) throws ResourceNotFoundException;

	void createOwner(Long communityId, Owner owner) throws ResourceNotFoundException;

	void updateOwner(Long communityId, Long ownerId, Owner owner) throws EntityValidationException, ResourceNotFoundException;

	void deleteOwner(Long communityId, Long ownerId) throws ResourceNotFoundException;

}
