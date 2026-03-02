package com.example.bankservice.application.port.in.update.command;

import com.example.bankservice.domain.model.enums.TipoCuenta;

public record UpdateCuentaCommand(
    TipoCuenta tipoCuenta,
    Boolean estado

) { }
