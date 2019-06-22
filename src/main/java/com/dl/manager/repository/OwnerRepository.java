package com.dl.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.manager.entity.Owner;

/**
 * 
 * @author duskol Jun 22, 2019
 *
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	List<Owner> findByCommunityId(Long id);

	Owner findByIdAndCommunityId(Long Id, Long communityid);
	
}
