package com.dl.manager.entity.provider;

import com.dl.manager.entity.Community;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
public interface EntityProviderInterface {
	
	Community getCommunityFromDb(Long id);

}
