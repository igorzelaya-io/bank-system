package com.example.bankservice.domain.model;

import com.example.bankservice.application.port.in.update.command.UpdateClienteCommand;

import java.util.UUID;

public record Cliente (
        UUID id,
        String clienteId,
        String passwordHash,
        boolean estado,
        Persona persona
) {

    public Cliente update(UpdateClienteCommand command) {

        Persona updatedPersona = new Persona(
                this.persona().id(),
                command.nombre(),
                command.genero(),
                command.edad(),
                command.identificacion(),
                command.direccion(),
                command.telefono()
        );

        return new Cliente(
                this.id(),
                this.clienteId(),
                command.password(),   // hash outside
                command.estado(),
                updatedPersona
        );
    }

    public Cliente changeEstado(Boolean estado) {
        return new Cliente(
                this.id(),
                this.clienteId(),
                this.passwordHash(),
                estado,
                this.persona()
        );
    }


}