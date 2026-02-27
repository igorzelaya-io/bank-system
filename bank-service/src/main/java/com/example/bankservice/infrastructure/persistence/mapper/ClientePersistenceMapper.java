package com.example.bankservice.infrastructure.persistence.mapper;


import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Persona;
import com.example.bankservice.infrastructure.persistence.entity.ClienteEntity;
import com.example.bankservice.infrastructure.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {

    PersonaEntity toPersonaEntity(Persona persona);

    @Mapping(target = "persona", source = "persona")
    @Mapping(target = "password", source = "passwordHash")
    ClienteEntity toClienteEntity(Cliente cliente);

    @Mapping(target = "passwordHash", source = "password")
    @Mapping(target = "persona", source = "persona")
    Cliente toDomain(ClienteEntity entity);

}
