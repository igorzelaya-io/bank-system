package com.example.bankservice.application.port.in.create;

import com.example.bankservice.application.port.in.create.command.CreateMovimientoCommand;
import com.example.bankservice.domain.model.Movimiento;

public interface CreateMovimientoUseCase {

    Movimiento create(CreateMovimientoCommand command);

}
