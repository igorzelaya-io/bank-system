package com.example.bankservice.infrastructure.web.dto.response;

import com.example.bankservice.domain.model.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record MovimientoResponse(
        UUID id,
        UUID cuentaId,
        LocalDateTime fecha,
        TipoMovimiento tipo,
        BigDecimal valor,
        BigDecimal saldoRestante
) { }