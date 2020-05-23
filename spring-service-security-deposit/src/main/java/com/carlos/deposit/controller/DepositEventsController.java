package com.carlos.deposit.controller;
import com.carlos.deposit.domain.Transaction;
import com.carlos.deposit.producer.DepositEventProducer;
import com.carlos.deposit.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class DepositEventsController {

    private Logger log= LoggerFactory.getLogger(DepositEventProducer.class);

    @Autowired
    DepositEventProducer depositEventProducer;
    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/v1/depositevent")
    public ResponseEntity<Transaction> postDepositEvent(@RequestBody Transaction transacitonEvent) throws JsonProcessingException{

        log.info("antes tranSql ");
        Transaction tranSql= transactionService.save(transacitonEvent);
        log.info("despues tranSql ");
        log.info("antes sendDepositEvent ");
        depositEventProducer.sendDepositEvent(tranSql);
        log.info("antes sendDepositEvent ");
        return ResponseEntity.status(HttpStatus.CREATED).body(tranSql);
    }

}
