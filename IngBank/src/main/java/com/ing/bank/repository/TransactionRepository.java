package com.ing.bank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.bank.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "select * from transaction t where date between :fromDate and :toDate",nativeQuery=true)
	public List<?> getAllBetweenDates(Date fromDate,Date toDate);
}

