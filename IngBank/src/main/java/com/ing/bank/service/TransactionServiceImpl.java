package com.ing.bank.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.model.Account;
import com.ing.bank.model.Transaction;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;

	public void saveTransaction(Long accountId, Transaction transaction) {
		Optional<Account> account  = accountRepository.findById(accountId);
		if(account.isPresent()) {
		transaction.setAccount(account.get());
		}
		if(transaction.getPaymentType().equals("credit")) {
		Double totalAmount = (transaction.getAmount() + account.get().getAccontBalance());
		System.out.println("transaction.getAmount()::" +transaction.getAmount());
		System.out.println("account.get().getAccontBalance()::"+account.get().getAccontBalance());
		transaction.setAmount(totalAmount);
		}
		else {
			 double totalAmount= (account.get().getAccontBalance() - transaction.getAmount());
			 transaction.setAmount(totalAmount);
		}
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getallTransactionDetail() {
		return transactionRepository.findAll();
	}

	@Override
	public Optional<Transaction> getRecoredByTransactionId(Long id) {
		return transactionRepository.findById(id);
	}

	public List<?> getDataBetweenDate(Date fromDate, Date toDate) {
		return transactionRepository.getAllBetweenDates(fromDate, toDate);
	}
	
}
