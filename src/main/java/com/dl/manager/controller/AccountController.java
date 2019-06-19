package com.dl.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.manager.service.AccountServiceInterface;
import com.dl.manager.service.CommunityServiceInterface;

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

}
