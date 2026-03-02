package com.example.reportsystem.infrastructure.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record MovimientoResponse(
        UUID id,
        UUID cuentaId,
        LocalDateTime fecha,
        String tipo,
        BigDecimal valor,
        BigDecimal saldoRestante
) {}