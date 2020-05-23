package com.carlos.historical.service;

import com.carlos.historical.model.entity.Transaction;
import com.carlos.historical.model.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements  ItransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;


    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Iterable<Transaction> findByAccountId(Integer accounId) {
        return transactionRepository.findByAccountId(accounId);
    }

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
