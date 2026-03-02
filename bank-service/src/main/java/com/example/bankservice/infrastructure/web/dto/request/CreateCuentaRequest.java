package com.example.bankservice.infrastructure.web.dto.request;

import com.example.bankservice.domain.model.enums.TipoCuenta;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateCuentaRequest(

        @NotBlank String numeroCuenta,
        @NotNull TipoCuenta tipo,
        @NotNull @DecimalMin(value = "0.0", inclusive = true) BigDecimal saldoInicial,
        @NotNull String clienteId

) { }
