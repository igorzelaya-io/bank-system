package com.example.bankservice.domain.model;

import com.example.bankservice.domain.exception.CuentaInactivaException;
import com.example.bankservice.domain.exception.SaldoNoDisponibleException;
import com.example.bankservice.domain.model.enums.TipoCuenta;

import java.math.BigDecimal;
import java.util.UUID;

public class Cuenta {

    private UUID id;
    private String numeroCuenta;
    private TipoCuenta tipo;
    private BigDecimal saldoInicial;
    private BigDecimal saldoActual;
    private boolean estado;
    private UUID clienteId;

    public void aplicarMovimiento(Movimiento movimiento) {

        if (!estado) {
            throw new CuentaInactivaException();
        }

        BigDecimal nuevoSaldo = saldoActual.add(movimiento.getValor());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoNoDisponibleException();
        }

        this.saldoActual = nuevoSaldo;
        movimiento.setSaldoRestante(nuevoSaldo);
    }
}