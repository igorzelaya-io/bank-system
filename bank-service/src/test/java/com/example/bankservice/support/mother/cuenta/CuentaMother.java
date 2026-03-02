package com.example.bankservice.support.mother.cuenta;

import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.domain.model.enums.TipoCuenta;

import java.math.BigDecimal;
import java.util.UUID;

public final class CuentaMother {
    public static Cuenta valid() {
        return Cuenta.builder()
                .id(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .numeroCuenta("ACC-0001")
                .tipo(TipoCuenta.AHORRO)
                .saldoInicial(new BigDecimal("1000.00"))
                .saldoActual(new BigDecimal("1500.00"))
                .estado(true)
                .clienteId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .build();
    }

    public static Cuenta anotherValid() {
        return Cuenta.builder()
                .id(UUID.randomUUID())
                .numeroCuenta("ACC-DEFAULT")
                .tipo(TipoCuenta.AHORRO)
                .saldoInicial(new BigDecimal("1000.00"))
                .saldoActual(new BigDecimal("1000.00"))
                .estado(true)
                .clienteId(UUID.randomUUID())
                .build();
    }
}

