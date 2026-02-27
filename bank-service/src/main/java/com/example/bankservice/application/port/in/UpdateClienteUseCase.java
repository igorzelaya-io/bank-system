package com.example.bankservice.application.port.in;

import com.example.bankservice.domain.model.Cliente;

public interface UpdateClienteUseCase {

    Cliente update(String clienteId, UpdateClienteCommand command);


}
