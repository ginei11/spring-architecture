package com.carlos.deposit.service;

import com.carlos.deposit.domain.Transaction;

public interface ITransactionService {

    public Transaction findById(Integer id);

    public Transaction save(Transaction transaction);

}
