package com.roach43.desafio_itau.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roach43.desafio_itau.dto.StatisticsResponse;
import com.roach43.desafio_itau.service.TransactionService;


@RestController
@RequestMapping(value ="/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;

    @Autowired
    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public ResponseEntity<StatisticsResponse> getStatistics(){
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        System.out.println("Statistics: " + stats);
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
