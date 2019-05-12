package com.dl.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.manager.entity.Community;

/**
 * 
 * @author duskol May 12, 2019
 *
 */
@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

}
