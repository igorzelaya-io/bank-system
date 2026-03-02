package com.example.bankservice.infrastructure.persistence.adapter;

import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.infrastructure.persistence.entity.CuentaEntity;
import com.example.bankservice.infrastructure.persistence.mapper.CuentaPersistenceMapper;
import com.example.bankservice.infrastructure.persistence.repository.CuentaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class CuentaRepositoryPortAdapter implements CuentaRepositoryPort {

    private final CuentaJpaRepository cuentaJpaRepository;

    private final CuentaPersistenceMapper cuentaMapper;

    @Override
    public Optional<Cuenta> findById(UUID cuentaId) {
        return cuentaJpaRepository.findById(cuentaId)
                .map(cuentaMapper::toDomain);
    }

    @Override
    public boolean existsByNumeroCuenta(String numeroCuenta) {
        return cuentaJpaRepository.existsByNumeroCuenta(numeroCuenta);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        final CuentaEntity entity = cuentaMapper.toEntity(cuenta);
        return cuentaMapper.toDomain(cuentaJpaRepository.save(entity));
    }

    @Override
    public Optional<Cuenta> findByNumeroCuenta(String numeroCuenta) {
        return cuentaJpaRepository.findByNumeroCuenta(numeroCuenta)
                .map(cuentaMapper::toDomain);
    }

    @Override
    public List<Cuenta> findByClienteId(UUID clienteId) {
        return cuentaJpaRepository.findByClienteId(clienteId)
                .stream()
                .map(cuentaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaJpaRepository.findAll()
                .stream()
                .map(cuentaMapper::toDomain)
                .toList();
    }
}
