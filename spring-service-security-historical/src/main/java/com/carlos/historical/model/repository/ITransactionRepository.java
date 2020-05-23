package com.carlos.historical.model.repository;

import com.carlos.historical.model.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ITransactionRepository extends MongoRepository<Transaction, String> {

    @Query("{'accountId:?0'}")
    public Iterable<Transaction> findByAccountId(Integer accountId);
}
