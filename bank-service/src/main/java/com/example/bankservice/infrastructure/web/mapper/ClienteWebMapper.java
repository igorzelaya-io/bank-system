package com.example.bankservice.infrastructure.web.mapper;

import com.example.bankservice.application.port.in.CreateClienteCommand;
import com.example.bankservice.application.port.in.UpdateClienteCommand;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Persona;
import com.example.bankservice.infrastructure.web.dto.request.UpdateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.response.ClienteResponse;
import com.example.bankservice.infrastructure.web.dto.request.CreateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.response.PersonaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteWebMapper {

    ClienteResponse toResponse(Cliente cliente);

    default PersonaResponse toPersonaResponse(Persona persona) {
        return new PersonaResponse(
                persona.id(),
                persona.nombre(),
                persona.genero(),
                persona.edad(),
                persona.identificacion(),
                persona.direccion(),
                persona.telefono()
        );
    }

    CreateClienteCommand toCreateCommand(CreateClienteRequest request);

    UpdateClienteCommand toUpdateCommand(UpdateClienteRequest request);
}