package com.example.bankservice.application.port.in.patch;

import com.example.bankservice.domain.model.Cliente;

public interface PatchClienteUseCase {
    Cliente patchEstado(String clienteId, Boolean estado);

}
