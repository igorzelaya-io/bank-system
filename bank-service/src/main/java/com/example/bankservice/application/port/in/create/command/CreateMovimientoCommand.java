package com.example.bankservice.application.port.in.create.command;


import com.example.bankservice.domain.model.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateMovimientoCommand(

    UUID cuentaId,

    TipoMovimiento tipo,

    BigDecimal valor

) { }
