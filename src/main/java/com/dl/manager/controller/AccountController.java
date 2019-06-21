package com.dl.manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.exception.ResourceNotFoundException;
import com.dl.manager.service.AccountServiceInterface;

/**
 * 
 * @author duskol Jun 19, 2019
 *
 */
@RestController
@RequestMapping(value="/manager/")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AccountServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="communities/{id}/accounts", method= RequestMethod.GET)
	public List<BankAccount> getAllAccounts(@PathVariable Long id) throws ResourceNotFoundException {
		return service.getAllAccounts(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value="communities/{id}/accounts", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createAccount(@PathVariable Long id, @Valid @RequestBody BankAccount account) throws ResourceNotFoundException {
		service.createAccount(id, account);
	}
	
	@RequestMapping(value="communities/{id}/accounts/{accountId}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateAccount(@PathVariable Long id, @PathVariable Long accountId, @Valid @RequestBody BankAccount account) throws ResourceNotFoundException {
		service.updateAccount(id, accountId, account);
	}

}
