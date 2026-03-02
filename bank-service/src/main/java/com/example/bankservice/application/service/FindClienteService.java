package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.get.FindClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.infrastructure.persistence.mapper.ClientePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindClienteService implements FindClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;

    private final ClientePersistenceMapper clienteMapper;

    @Override
    public Cliente findByClienteId(String clienteId) {
        return clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cliente no fue encontrado por ID: '%s'", clienteId)));
    }
}
