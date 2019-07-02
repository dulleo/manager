package com.dl.manager.service;

import java.util.List;

import com.dl.manager.entity.dto.OwnerDTO;

/**
 * 
 * @author duskol Jul 2, 2019
 *
 */
public interface ApartmentOwnerInterface {

	List<OwnerDTO> getOwnersForAccount(Long apartmentId);

}
