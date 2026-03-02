package com.example.bankservice.support.mother.cuenta;

import com.example.bankservice.domain.model.enums.TipoCuenta;
import com.example.bankservice.infrastructure.web.dto.response.CuentaResponse;

import java.math.BigDecimal;
import java.util.UUID;

public final class CuentaResponseMother {

    private CuentaResponseMother() {}

    public static CuentaResponse validResponse() {
        return new CuentaResponse(
                "11111111-1111-1111-1111-111111111111", TipoCuenta.AHORRO, new BigDecimal("1000.00"),
                true, UUID.fromString("22222222-2222-2222-2222-222222222222"));
    }

}