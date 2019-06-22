package com.dl.manager.service;

import java.util.List;

import javax.validation.Valid;

import com.dl.manager.entity.Doorway;

public class DoorwayService implements DoorwayServiceInterface {

	@Override
	public List<Doorway> getAllDoorways(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDoorway(Long id, @Valid Doorway doorway) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDoorway(Long id, Long accountId, @Valid Doorway doorway) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDoorway(Long id, Long accountId) {
		// TODO Auto-generated method stub

	}

}
