package com.dl.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.manager.entity.BankAccount;

/**
 * 
 * @author duskol Jun 19, 2019
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long>{

	List<BankAccount> findByCommunityId(Long id);

	void findByIdAndCommunityId(Long accountId, Long id);

}
