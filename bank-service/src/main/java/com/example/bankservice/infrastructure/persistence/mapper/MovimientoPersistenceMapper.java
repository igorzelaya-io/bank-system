package com.example.bankservice.infrastructure.persistence.mapper;


import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.persistence.entity.MovimientoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoPersistenceMapper {

    MovimientoEntity toEntity(Movimiento movimiento);

    Movimiento toDomain(MovimientoEntity movimiento);


}
