package com.dl.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dl.manager.entity.Owner;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Service
public interface OwnerServiceInterface {

	List<Owner> getAllOwners(Long id);

	void createOwner(Long id, Owner owner);

	void updateOwner(Long id, Long ownerId, Owner owner);

	void deleteOwner(Long id, Long ownerId);

}
