package com.roach43.desafio_itau.dto;

import java.time.OffsetDateTime;

import com.roach43.desafio_itau.model.Transaction;

import jakarta.validation.constraints.NotNull;


public class TransactionRequest {
    
    @NotNull
    private double valor;

    @NotNull
    private OffsetDateTime datahora;

    
    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDatahora() {
        return datahora;
    }

    public Transaction toModel() {
        return new Transaction(valor, datahora);
    }

}
