package com.example.bankservice.application.port.in.get;

import com.example.bankservice.domain.model.Cuenta;

import java.util.List;

public interface FindCuentaUseCase {

    Cuenta findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findAll();

    List<Cuenta> findAllByKeyword(String keyword);

}
