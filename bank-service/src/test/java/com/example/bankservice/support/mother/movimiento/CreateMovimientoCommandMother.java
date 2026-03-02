package com.example.bankservice.support.mother.movimiento;

import com.example.bankservice.application.port.in.create.command.CreateMovimientoCommand;
import com.example.bankservice.domain.model.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.util.UUID;

public final class CreateMovimientoCommandMother {

    private CreateMovimientoCommandMother() {}

    public static CreateMovimientoCommand validCommand() {
        return new CreateMovimientoCommand(
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                TipoMovimiento.RETIRO,
                new BigDecimal("500")
        );
    }
}