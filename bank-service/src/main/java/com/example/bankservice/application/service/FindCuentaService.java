package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.get.FindCuentaUseCase;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindCuentaService implements FindCuentaUseCase {

    private final CuentaRepositoryPort cuentaRepository;

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public List<Cuenta> findAllByKeyword(String keyword) {
        return cuentaRepository.findAllByKeyword(keyword);
    }

    @Override
    public Cuenta findByNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Resource was not found for '%s'", numeroCuenta)));
    }

}
