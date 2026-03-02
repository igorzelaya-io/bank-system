package com.example.bankservice.support.mother.cuenta;

import com.example.bankservice.domain.model.enums.TipoCuenta;
import com.example.bankservice.infrastructure.web.dto.request.CreateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateCuentaRequest;

import java.math.BigDecimal;

public final class CuentaRequestMother {

    private CuentaRequestMother() {
    }

    public static CreateCuentaRequest validCreate() {
        return new CreateCuentaRequest(
                "ACC-0001",
                TipoCuenta.AHORRO,
                new BigDecimal("1000.00"),
                "22222222-2222-2222-2222-222222222222"
        );
    }

    public static CreateCuentaRequest invalidCreate() {
        return new CreateCuentaRequest(
                "",                         // invalid numeroCuenta
                null,                       // invalid tipo
                new BigDecimal("-100.00"),  // invalid saldo
                null                        // invalid clienteId
        );
    }

    public static UpdateCuentaRequest validUpdate() {
        return new UpdateCuentaRequest(
                TipoCuenta.CORRIENTE,
                true
        );
    }

    public static UpdateCuentaRequest invalidUpdate() {
        return new UpdateCuentaRequest(
                null,
                null
        );
    }
}