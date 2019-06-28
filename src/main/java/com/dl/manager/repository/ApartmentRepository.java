package com.dl.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.manager.entity.Apartment;

/**
 * 
 * @author duskol Jun 23, 2019
 *
 */
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

	List<Apartment> findByDoorwayId(Long id);

}
