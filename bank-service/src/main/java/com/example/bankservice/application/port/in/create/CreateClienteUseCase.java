package com.example.bankservice.application.port.in.create;

import com.example.bankservice.application.port.in.create.command.CreateClienteCommand;
import com.example.bankservice.domain.model.Cliente;

public interface CreateClienteUseCase {

    Cliente create(CreateClienteCommand command);
}
