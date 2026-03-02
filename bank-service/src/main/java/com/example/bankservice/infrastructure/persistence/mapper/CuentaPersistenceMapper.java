package com.example.bankservice.infrastructure.persistence.mapper;

import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.infrastructure.persistence.entity.CuentaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaPersistenceMapper {
    CuentaEntity toEntity(Cuenta cuenta);

    Cuenta toDomain(CuentaEntity entity);

}
