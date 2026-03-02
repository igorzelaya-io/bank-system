package com.example.bankservice.domain.model;

import com.example.bankservice.domain.model.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Movimiento {
    private UUID id;
    private UUID cuentaId;
    private LocalDateTime fecha;
    private TipoMovimiento tipo;
    private BigDecimal valor;
    private BigDecimal saldoRestante;

    public Movimiento(UUID id, UUID cuentaId, LocalDateTime fecha, TipoMovimiento tipo, BigDecimal valor) {
        this.id = id;
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(UUID cuentaId) {
        this.cuentaId = cuentaId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(BigDecimal saldoRestante) {
        this.saldoRestante = saldoRestante;
    }
}