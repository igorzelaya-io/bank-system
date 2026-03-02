package com.example.bankservice.infrastructure.web.dto.request;

import com.example.bankservice.domain.model.enums.TipoMovimiento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateMovimientoRequest(
        @NotNull UUID cuentaId,
        @NotNull BigDecimal valor,
        @NotNull TipoMovimiento tipo
) { }

