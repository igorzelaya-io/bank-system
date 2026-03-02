package com.example.bankservice.application.port.in.update;

import com.example.bankservice.application.port.in.update.command.UpdateCuentaCommand;
import com.example.bankservice.domain.model.Cuenta;

public interface UpdateCuentaUseCase {

    Cuenta update(String numeroCuenta, UpdateCuentaCommand command);

}
