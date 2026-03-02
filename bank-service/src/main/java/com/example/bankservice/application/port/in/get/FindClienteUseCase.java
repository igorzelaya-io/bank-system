package com.example.bankservice.application.port.in.get;

import com.example.bankservice.domain.model.Cliente;

public interface FindClienteUseCase {

    Cliente findByClienteId(String clienteId);


}
