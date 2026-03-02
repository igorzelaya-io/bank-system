package com.example.reportsystem.infrastructure.web.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CuentaReport (
        UUID cuentaId,
        String numeroCuenta,
        BigDecimal saldoActual,
        List<MovimientoReport> movimientos
) {}

