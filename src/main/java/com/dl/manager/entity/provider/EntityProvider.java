package com.dl.manager.entity.provider;

import org.springframework.stereotype.Component;

import com.dl.manager.entity.Community;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Component
public class EntityProvider implements EntityProviderInterface {

	@Override
	public Community getCommunityFromDb(Long id) {
		
		return null;
	}

}
