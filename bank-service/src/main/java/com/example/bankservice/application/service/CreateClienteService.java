package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.CreateClienteCommand;
import com.example.bankservice.application.port.in.CreateClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.application.port.out.PasswordHashserPort;
import com.example.bankservice.domain.exception.DuplicateResourceException;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateClienteService implements CreateClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    private final PasswordHashserPort passwordHashserPort;

    @Override
    public Cliente create(CreateClienteCommand command) {
        if(clienteRepositoryPort.existsByClienteId(command.clienteId())) {
            throw new DuplicateResourceException("Cliente ID", command.clienteId());
        }
        if(clienteRepositoryPort.existsByIdentificacion(command.identificacion())) {
            throw new DuplicateResourceException("Identificación", command.identificacion());
        }

        final UUID personaId = UUID.randomUUID();

        final Persona persona = new Persona(personaId, command.nombre(), command.genero(), command.edad(),
                command.identificacion(), command.direccion(), command.telefono());

        final Cliente cliente = new Cliente(personaId, command.clienteId(), passwordHashserPort.hash(command.password()),
                true, persona);

        return clienteRepositoryPort.save(cliente);
    }
}
