package com.example.bankservice.application.port.out;

import com.example.bankservice.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CuentaRepositoryPort {

    Optional<Cuenta> findById(UUID cuentaId);

    boolean existsByNumeroCuenta(String numeroCuenta);

    Cuenta save(Cuenta cuenta);

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findByClienteId(UUID clienteId);

    List<Cuenta> findAll();

    List<Cuenta> findAllByKeyword(String keyword);

}
