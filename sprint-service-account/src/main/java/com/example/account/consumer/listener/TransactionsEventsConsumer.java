package com.example.account.consumer.listener;

import com.example.account.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionsEventsConsumer {
    @Autowired
    private TransactionEvents transactionEvents;

    private Logger log = LoggerFactory.getLogger(TransactionsEventsConsumer.class);

    @KafkaListener(topics = {"transaction-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

        log.info("Consumer Record", consumerRecord);
        transactionEvents.processTransactionEvent(consumerRecord);
    }

}
