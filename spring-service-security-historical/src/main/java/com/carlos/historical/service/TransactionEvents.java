package com.carlos.historical.service;

import com.carlos.historical.model.entity.Transaction;
import com.carlos.historical.model.repository.ITransactionRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionEvents  {

    @Autowired
    private ITransactionRepository repository ;
    @Autowired
    ObjectMapper objectMapper ;
    private Logger log =LoggerFactory.getLogger(TransactionEvents.class);
    public void processTransactionEvent(ConsumerRecord<Integer,String> consumerRecord) throws JsonMappingException, JsonProcessingException {

        Transaction transactionEvent= objectMapper.readValue(consumerRecord.value(), Transaction.class);
        log.info("transactionEvent:{}",transactionEvent);
        repository.save(transactionEvent);
    }


}
