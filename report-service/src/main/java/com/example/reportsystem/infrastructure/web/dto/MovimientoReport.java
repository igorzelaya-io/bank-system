package com.example.reportsystem.infrastructure.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimientoReport(
        LocalDateTime fecha,
        String tipo,
        BigDecimal valor,
        BigDecimal saldoRestante
) { }