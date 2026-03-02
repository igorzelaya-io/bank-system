package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.update.command.UpdateClienteCommand;
import com.example.bankservice.application.port.in.update.UpdateClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.application.port.out.PasswordHashserPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateClienteService implements UpdateClienteUseCase {

    private final ClienteRepositoryPort repositoryPort;

    private final PasswordHashserPort passwordEncoder;

    @Override
    public Cliente update(String clienteId, UpdateClienteCommand command) {

        Cliente existing = repositoryPort.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cliente no fue encontrado por el ID: %s", clienteId)));

        if(command.password() != null && !StringUtils.isBlank(command.password())) {
             passwordEncoder.hash(command.password());
        }

        Cliente updated = existing.update(command);

        return repositoryPort.save(updated);

    }
}
