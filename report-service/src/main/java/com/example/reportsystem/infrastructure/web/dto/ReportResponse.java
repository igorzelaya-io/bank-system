package com.example.reportsystem.infrastructure.web.dto;

import java.util.List;
import java.util.UUID;

public record ReportResponse(
        UUID clienteId,
        String nombreCliente,
        List<CuentaReport> cuentas
) {}