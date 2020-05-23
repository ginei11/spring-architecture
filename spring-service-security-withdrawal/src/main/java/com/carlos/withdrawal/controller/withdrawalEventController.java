package com.carlos.withdrawal.controller;

import com.carlos.withdrawal.domain.Withdrawal;
import com.carlos.withdrawal.producer.WithdrawalEventProducer;
import com.carlos.withdrawal.service.IWithdrawalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class withdrawalEventController {
    private Logger log= LoggerFactory.getLogger(withdrawalEventController.class);

    @Autowired
    WithdrawalEventProducer withdrawalEventProducer;

    @Autowired
    private IWithdrawalService withdrawalService;

    @PostMapping("/v1/withdrawal")
    public ResponseEntity<Withdrawal> postWithdrawalEvent(@RequestBody Withdrawal withdrawalEvent) throws JsonProcessingException{
        Withdrawal withdrawalSql = withdrawalService.save(withdrawalEvent);
        withdrawalEventProducer.sendDepositEvent(withdrawalSql);
        return ResponseEntity.status(HttpStatus.CREATED).body(withdrawalEvent);
    }



}
