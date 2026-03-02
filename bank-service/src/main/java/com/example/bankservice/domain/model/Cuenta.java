package com.example.bankservice.domain.model;

import com.example.bankservice.domain.exception.CuentaInactivaException;
import com.example.bankservice.domain.exception.SaldoNoDisponibleException;
import com.example.bankservice.domain.model.enums.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    private UUID id;
    private String numeroCuenta;
    private TipoCuenta tipo;
    private BigDecimal saldoInicial;
    private BigDecimal saldoActual;
    private boolean estado;
    private UUID clienteId;

    public Cuenta actualizarEstado(boolean estado) {
        this.estado = estado;
        return this;
    }

    public Cuenta actualizarTipoCuenta(TipoCuenta cuenta) {
        this.tipo = cuenta;
        return this;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void aplicarMovimiento(Movimiento movimiento) {

        if (!estado) {
            throw new CuentaInactivaException();
        }

        if (movimiento.getValor() == null) {
            throw new IllegalArgumentException("El valor es obligatorio");
        }

        BigDecimal nuevoSaldo = saldoActual.add(movimiento.getValor());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoNoDisponibleException("Fondos insuficientes.");
        }

        this.saldoActual = nuevoSaldo;
        movimiento.setSaldoRestante(nuevoSaldo);
    }
}