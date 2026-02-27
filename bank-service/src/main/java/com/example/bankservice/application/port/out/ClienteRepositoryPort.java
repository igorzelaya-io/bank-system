package com.example.bankservice.application.port.out;

import com.example.bankservice.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Optional<Cliente> findByClienteId(String clienteId);

    boolean existsByClienteId(String clienteId);

    boolean existsByIdentificacion(String identificacion);

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(String id);

}
