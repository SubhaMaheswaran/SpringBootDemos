package com.ing.bank.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.model.Transaction;
import com.ing.bank.service.TransactionServiceImpl;

@RestController
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@PostMapping("/saveTransaction/{accountId}")
	public void saveTransRecord(@PathVariable("accountId") Long accountId, @RequestBody Transaction transaction) {
		transactionServiceImpl.saveTransaction(accountId, transaction);
	}

	@GetMapping("/getAllTransactionDetail")
	public List<Transaction> getallTransactionDetail() {
		return transactionServiceImpl.getallTransactionDetail();
	}

	@GetMapping("/getRecoredByTransactionId/{id}")
	public Optional<Transaction> getRecoredByTransactionId(@PathVariable("id") Long id) {
		return transactionServiceImpl.getRecoredByTransactionId(id);
	}
	
	@GetMapping("/getDataBetweenDate/{fromDate}/{toDate}")
	public List<?> getDataBetweenDate(@RequestParam("fromDate") @DateTimeFormat(pattern ="yyyy-MM-dd") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern ="yyyy-MM-dd") Date  toDate ) {
	return transactionServiceImpl.getDataBetweenDate(fromDate,toDate);
	}
}
