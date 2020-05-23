package com.example.account.service;

import com.example.account.model.entity.Account;
import com.example.account.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionEvents   {

    @Autowired
    private  IAccountService iAccountService;
    @Autowired
    ObjectMapper objectMapper;
    private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
    public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

        double newMonto = 0;
        Account objectAccount = new Account();
        Transaction transactionEvent= objectMapper.readValue(consumerRecord.value(), Transaction.class);
        log.info("transactionEvents={}", transactionEvent.getAccountId());
        objectAccount=iAccountService.findById(transactionEvent.getAccountId());

        switch (transactionEvent.getType()){
            case "deposito": newMonto = objectAccount.getTotalAmount() + transactionEvent.getAmount();
            break;
            case "retiro": newMonto = objectAccount.getTotalAmount() - transactionEvent.getAmount();
                break;
        }

        objectAccount.setTotalAmount(newMonto);
        iAccountService.save(objectAccount);
    }

}
