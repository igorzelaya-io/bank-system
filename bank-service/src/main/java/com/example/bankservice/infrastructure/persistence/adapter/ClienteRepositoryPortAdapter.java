package com.example.bankservice.infrastructure.persistence.adapter;

import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.infrastructure.persistence.entity.ClienteEntity;
import com.example.bankservice.infrastructure.persistence.mapper.ClientePersistenceMapper;
import com.example.bankservice.infrastructure.persistence.repository.ClienteJpaRepository;
import com.example.bankservice.infrastructure.persistence.repository.PersonaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryPortAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    private final PersonaJpaRepository personaJpaRepository;

    private final ClientePersistenceMapper clienteMapper;

    @Override
    public Optional<Cliente> findByClienteId(String clienteId) {
        return clienteJpaRepository.findByClienteId(clienteId)
                .map(clienteMapper::toDomain);
    }

    @Override
    public boolean existsByClienteId(String clienteId) {
        return clienteJpaRepository.existsByClienteId(clienteId);
    }

    @Override
    public boolean existsByIdentificacion(String identificacion) {
        return personaJpaRepository.existsByIdentificacion(identificacion);
    }

    @Override
    public Cliente save(Cliente cliente) {
        final ClienteEntity entity = clienteMapper.toClienteEntity(cliente);
        return clienteMapper.toDomain(clienteJpaRepository.save(entity));
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return clienteJpaRepository.findByClienteId(id)
                .map(clienteMapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteJpaRepository.findAll()
                .stream().map(clienteMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cliente> findAllByKeyword(String keyword) {
        return clienteJpaRepository.findAllByClienteIdContainingIgnoreCase(keyword)
                .stream()
                .map(clienteMapper::toDomain)
                .toList();
    }
}
