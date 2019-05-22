package com.ing.bank.service;

import java.util.List;
import java.util.Optional;

import com.ing.bank.model.Transaction;

public interface TransactionService {
	public void saveTransaction(Long accountId,Transaction transaction);
	public List<Transaction> getallTransactionDetail();
	public Optional<Transaction> getRecoredByTransactionId(Long id);
}
