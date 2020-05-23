package com.carlos.deposit.service;

import com.carlos.deposit.dao.TransactionDao;
import com.carlos.deposit.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    @Transactional(readOnly=true)
    public Transaction findById(Integer id) {
        return transactionDao.findById(id).orElse(null);

    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        // TODO Auto-generated method stub
        return transactionDao.save(transaction);
    }

}

