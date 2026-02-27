package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.PatchClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatchServiceClient implements PatchClienteUseCase {

    private final ClienteRepositoryPort repositoryPort;

    @Override
    public Cliente patchEstado(String clienteId, Boolean estado) {

        final Cliente existing = repositoryPort.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cliente no fue encontrado por el ID: %s", clienteId)));

        final Cliente updated = existing.changeEstado(estado);

        return repositoryPort.save(updated);
    }
}
