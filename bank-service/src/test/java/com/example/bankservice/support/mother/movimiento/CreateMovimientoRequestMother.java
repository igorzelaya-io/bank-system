package com.example.bankservice.support.mother.movimiento;

import com.example.bankservice.domain.model.enums.TipoMovimiento;
import com.example.bankservice.infrastructure.web.dto.request.CreateMovimientoRequest;

import java.math.BigDecimal;
import java.util.UUID;

public final class CreateMovimientoRequestMother {

    private CreateMovimientoRequestMother() {}

    public static CreateMovimientoRequest valid() {
        return new CreateMovimientoRequest(
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                new BigDecimal("500"),
                TipoMovimiento.DEPOSITO
        );
    }

    public static CreateMovimientoRequest invalid() {
        return new CreateMovimientoRequest(
                null,
                new BigDecimal("-500"),
                TipoMovimiento.RETIRO
        );
    }
}