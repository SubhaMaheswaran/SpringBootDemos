package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.model.Account;
import com.ing.bank.service.AccountServiceImpl;

@RestController
public class AccountController {

	@Autowired
	private AccountServiceImpl accountServiceImpl;

	@PostMapping("/saveAccount")
	public void saveAccountDetails(@RequestBody Account account) {
		accountServiceImpl.saveAccountDetails(account);
	}

}




