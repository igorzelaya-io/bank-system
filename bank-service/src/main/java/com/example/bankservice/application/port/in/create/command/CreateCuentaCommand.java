package com.example.bankservice.application.port.in.create.command;

import com.example.bankservice.domain.model.enums.TipoCuenta;

import java.math.BigDecimal;

public record CreateCuentaCommand(

        String numeroCuenta,
        TipoCuenta tipo,
        BigDecimal saldoInicial,
        BigDecimal saldoActual,
        String clienteId

){ }