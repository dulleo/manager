package com.dl.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.manager.entity.Doorway;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Repository
public interface DoorwayRepository extends JpaRepository<Doorway, Long>{
	
	List<Doorway> findByCommunityId(Long id);

	Doorway findByIdAndCommunityId(Long Id, Long communityid);

}
