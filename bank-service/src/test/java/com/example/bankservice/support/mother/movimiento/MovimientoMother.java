package com.example.bankservice.support.mother.movimiento;

import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.domain.model.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class MovimientoMother {

    private MovimientoMother() {}

    public static Movimiento valid() {
        return new Movimiento(
                UUID.fromString("22222222-2222-2222-2222-222222222222"),
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                LocalDateTime.now(),
                TipoMovimiento.DEPOSITO,
                new BigDecimal("500")
        );
    }

}