package com.roach43.desafio_itau.model;

import java.time.OffsetDateTime;

public class Transaction {
    private final double valor;
    private final OffsetDateTime datahora;

    public Transaction(final double valor, final OffsetDateTime datahora) {
        this.valor = valor;
        this.datahora = datahora;
    }

    
    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDatahora() {
        return datahora;

    }
}
