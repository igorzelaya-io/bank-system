package com.example.bankservice.infrastructure.persistence.repository;

import com.example.bankservice.infrastructure.persistence.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CuentaJpaRepository extends JpaRepository<CuentaEntity, UUID> {

    boolean existsByNumeroCuenta(String numeroCuenta);

    Optional<CuentaEntity> findByNumeroCuenta(String numeroCuenta);

    List<CuentaEntity> findByClienteId(UUID clienteId);

    List<CuentaEntity> findAllByNumeroCuentaContainingIgnoreCase(String keyword);
}
