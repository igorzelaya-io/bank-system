package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.create.command.CreateCuentaCommand;
import com.example.bankservice.application.port.in.create.CreateCuentaUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.exception.DuplicateResourceException;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CreateCuentaService implements CreateCuentaUseCase {

    private final CuentaRepositoryPort cuentaRepository;

    private final ClienteRepositoryPort clienteRepository;

    @Override
    public Cuenta create(CreateCuentaCommand command) {

        if(!clienteRepository.existsByClienteId(command.clienteId())) {
            throw new ResourceNotFoundException(String
                    .format("Cliente con ID: %s no esta activo.", command.clienteId()));
        }
        if(cuentaRepository.existsByNumeroCuenta(command.numeroCuenta())) {
            throw new DuplicateResourceException("Numero Cuenta", command.numeroCuenta());
        }
        if(command.saldoInicial().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(String
                    .format("Saldo Inicial por el monto de: '%s' no puede ser menor a cero.", command.saldoInicial()));
        }

        Cuenta cuenta = Cuenta.builder()
                .id(UUID.randomUUID())
                .numeroCuenta(command.numeroCuenta())
                .tipo(command.tipo())
                .saldoInicial(command.saldoInicial())
                .saldoActual(command.saldoInicial())
                .estado(true)
                .clienteId(UUID.fromString(command.clienteId()))
                .build();

        return cuentaRepository.save(cuenta);

    }
}
