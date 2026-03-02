package com.example.bankservice.application.port.in.get;

import com.example.bankservice.domain.model.Cliente;

import java.util.List;

public interface FindClienteUseCase {

    Cliente findByClienteId(String clienteId);

    List<Cliente> findAllByKeyword(String keyword);

    List<Cliente> findAll();

}
