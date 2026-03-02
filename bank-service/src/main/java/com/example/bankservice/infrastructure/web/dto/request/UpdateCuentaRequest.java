package com.example.bankservice.infrastructure.web.dto.request;

import com.example.bankservice.domain.model.enums.TipoCuenta;
import jakarta.validation.constraints.NotNull;

public record UpdateCuentaRequest(
        @NotNull TipoCuenta tipoCuenta, @NotNull Boolean estado

){ }
