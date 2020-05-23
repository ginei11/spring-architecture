package com.carlos.historical.service;

import com.carlos.historical.model.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface ItransactionService  {

    public Transaction save (Transaction transaction);
    public Iterable<Transaction> findByAccountId(Integer accounId);
    public Iterable<Transaction> findAll();
}
