package com.roach43.desafio_itau.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roach43.desafio_itau.dto.TransactionRequest;
import com.roach43.desafio_itau.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao")
public class TransactionController {

    private final TransactionService transactionService;
    
    @Autowired
    public TransactionController(TransactionService transactionservice) {
        this.transactionService = transactionservice;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
        if (request.getDatahora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        
        transactionService.addTransaction(request.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } 

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }

    

    
    

}
