package com.example.bankservice.infrastructure.web.mapper;

import com.example.bankservice.application.port.in.create.command.CreateClienteCommand;
import com.example.bankservice.application.port.in.update.command.UpdateClienteCommand;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Persona;
import com.example.bankservice.infrastructure.web.dto.request.CreateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.response.ClienteResponse;
import com.example.bankservice.infrastructure.web.dto.response.PersonaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteWebMapper {

    ClienteResponse toResponse(Cliente cliente);

    List<ClienteResponse> toResponseList(List<Cliente> clientes);


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