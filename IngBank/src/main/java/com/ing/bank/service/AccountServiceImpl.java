package com.ing.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.model.Account;
import com.ing.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

@Autowired	
private AccountRepository accountRepository;

public void saveAccountDetails(Account account) {
	accountRepository.save(account);	
}

}
