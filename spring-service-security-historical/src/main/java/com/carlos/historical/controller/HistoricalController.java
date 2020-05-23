package com.carlos.historical.controller;

import com.carlos.historical.model.entity.Transaction;
import com.carlos.historical.service.ItransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoricalController {
    @Autowired
    private ItransactionService itransactionService;

    @GetMapping("/transaction/{accountId}")
    public ResponseEntity<?> obtenerByAccountId(@PathVariable Integer accoundId) {
        Iterable<Transaction> itransaction = itransactionService.findByAccountId(accoundId);
        return ResponseEntity.ok(itransaction);
    }

    @GetMapping("/listar")
    public List<Transaction> listar() {
        return (List<Transaction>) itransactionService.findAll();
    }
}
