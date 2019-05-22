package com.ing.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
