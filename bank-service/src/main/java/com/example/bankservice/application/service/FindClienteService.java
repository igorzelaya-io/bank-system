package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.get.FindClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.infrastructure.persistence.mapper.ClientePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClienteService implements FindClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;

    private final ClientePersistenceMapper clienteMapper;

    @Override
    public List<Cliente> findAllByKeyword(String keyword) {
        return clienteRepository.findAllByKeyword(keyword);
    }

    @Override
    public Cliente findByClienteId(String clienteId) {
        return clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cliente no fue encontrado por ID: '%s'", clienteId)));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
