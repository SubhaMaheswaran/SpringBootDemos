package com.ing.bank.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "account")
public class Account implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="account_id")
private Long accountId;

@Column(name ="accontBalance")
@Range(min = (long) 0.0, max = (long) 10.0)
private double accontBalance;

@OneToMany(fetch=FetchType.LAZY,mappedBy="account")
@JsonIgnoreProperties("account")
private List<Transaction>  transaction;

public Long getAccountId() {
	return accountId;
}

public void setAccountId(Long accountId) {
	this.accountId = accountId;
}

public double getAccontBalance() {
	return accontBalance;
}

public void setAccontBalance(double accontBalance) {
	this.accontBalance = accontBalance;
}

public List<Transaction> getTransaction() {
	return transaction;
}

public void setTransaction(List<Transaction> transaction) {
	this.transaction = transaction;
}


}
