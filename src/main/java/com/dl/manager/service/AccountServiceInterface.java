package com.dl.manager.service;

import java.util.List;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.exception.ResourceNotFoundException;

/**
 * 
 * @author duskol Jun 19, 2019
 *
 */
public interface AccountServiceInterface {

	List<BankAccount> getAllAccounts(Long id) throws ResourceNotFoundException;

	void createAccount(Long id, BankAccount account) throws ResourceNotFoundException;

	void updateAccount(Long id, Long accountId, BankAccount account);

}
