package com.dl.manager.service;

import java.util.List;

import javax.validation.Valid;

import com.dl.manager.entity.Doorway;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public interface DoorwayServiceInterface {

	List<Doorway> getAllDoorways(Long id);

	void createDoorway(Long id, @Valid Doorway doorway);

	void updateDoorway(Long id, Long accountId, @Valid Doorway doorway);

	void deleteDoorway(Long id, Long accountId);

}
