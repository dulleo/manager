package com.dl.manager.service;

import java.util.List;

import com.dl.manager.entity.Doorway;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public interface DoorwayServiceInterface {

	List<Doorway> getAllDoorways(Long communityId) throws ResourceNotFoundException;

	void createDoorway(Long communityId, Doorway doorway);

	void updateDoorway(Long communityId, Long accountId, Doorway doorway);

	void deleteDoorway(Long communityId, Long accountId);

}
