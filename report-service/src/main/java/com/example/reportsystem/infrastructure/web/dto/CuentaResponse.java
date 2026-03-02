package com.example.reportsystem.infrastructure.web.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CuentaResponse (
        UUID id,
        String numeroCuenta,
        String tipo,
        BigDecimal saldoInicial,
        BigDecimal saldoActual,
        boolean estado,
        UUID clienteId
) {}