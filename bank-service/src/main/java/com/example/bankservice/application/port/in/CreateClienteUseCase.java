package com.example.bankservice.application.port.in;

import com.example.bankservice.domain.model.Cliente;

public interface CreateClienteUseCase {

    Cliente create(CreateClienteCommand command);
}
