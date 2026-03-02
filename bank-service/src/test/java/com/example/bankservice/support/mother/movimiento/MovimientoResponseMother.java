package com.example.bankservice.support.mother.movimiento;

import com.example.bankservice.domain.model.enums.TipoMovimiento;
import com.example.bankservice.infrastructure.web.dto.response.MovimientoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class MovimientoResponseMother {

    private MovimientoResponseMother() {}

    public static MovimientoResponse validResponse() {
        return new MovimientoResponse(
                UUID.fromString("22222222-2222-2222-2222-222222222222"),
                UUID.fromString("11111111-1111-1111-1111-111111111111"),
                LocalDateTime.now(),
                TipoMovimiento.RETIRO,
                new BigDecimal("500"),
                new BigDecimal("1500")
        );
    }
}