package com.example.bankservice.application.port.in.create;

import com.example.bankservice.application.port.in.create.command.CreateCuentaCommand;
import com.example.bankservice.domain.model.Cuenta;

public interface CreateCuentaUseCase {
    Cuenta create(CreateCuentaCommand command);

}
