package com.example.bankservice.infrastructure.web.dto.response;

import com.example.bankservice.domain.model.enums.TipoCuenta;

import java.math.BigDecimal;
import java.util.UUID;

public record CuentaResponse(
        String numeroCuenta,
        TipoCuenta tipoCuenta,
        BigDecimal saldo,
        boolean estado,
        UUID clienteId
) {
}
