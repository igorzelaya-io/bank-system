package com.example.bankservice.application.port.in.get;

import com.example.bankservice.domain.model.Cuenta;

import java.util.List;

public interface FindCuentaUseCase {

    List<Cuenta> findAll();

    Cuenta findByNumeroCuenta(String numeroCuenta);

}
