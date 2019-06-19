package com.dl.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.entity.BankAccount;
import com.dl.manager.entity.Community;
import com.dl.manager.service.AccountServiceInterface;

/**
 * 
 * @author duskol Jun 19, 2019
 *
 */
@RestController
@RequestMapping(value="/manager/communities")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AccountServiceInterface service;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/accounts", method= RequestMethod.GET)
	public List<BankAccount> getAllAccounts() {
		return service.getAllAccounts();
	}

}
