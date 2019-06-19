package com.dl.manager.repository;

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

}
