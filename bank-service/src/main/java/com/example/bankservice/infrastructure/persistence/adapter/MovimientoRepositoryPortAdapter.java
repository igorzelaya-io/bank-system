package com.example.bankservice.infrastructure.persistence.adapter;

import com.example.bankservice.application.port.out.MovimientoRepositoryPort;
import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.persistence.entity.MovimientoEntity;
import com.example.bankservice.infrastructure.persistence.mapper.MovimientoPersistenceMapper;
import com.example.bankservice.infrastructure.persistence.repository.MovimientoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovimientoRepositoryPortAdapter implements MovimientoRepositoryPort {

    private final MovimientoJpaRepository movimientoJpaRepository;

    private final MovimientoPersistenceMapper movimientoMapper;

    @Override
    public Movimiento save(Movimiento movimiento) {
        final MovimientoEntity entity = movimientoMapper.toEntity(movimiento);
        return movimientoMapper.toDomain(movimientoJpaRepository.save(entity));
    }
}
