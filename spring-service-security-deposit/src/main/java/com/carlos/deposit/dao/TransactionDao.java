package com.carlos.deposit.dao;

import com.carlos.deposit.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDao extends CrudRepository<Transaction, Integer> {

}