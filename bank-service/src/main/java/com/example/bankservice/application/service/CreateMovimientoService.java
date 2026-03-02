package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.create.CreateMovimientoUseCase;
import com.example.bankservice.application.port.in.create.command.CreateMovimientoCommand;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.application.port.out.MovimientoRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.domain.model.Movimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateMovimientoService implements CreateMovimientoUseCase {

    private final MovimientoRepositoryPort movimientoRepository;

    private final CuentaRepositoryPort cuentaRepository;

    @Transactional
    @Override
    public Movimiento create(CreateMovimientoCommand command) {

        final Cuenta cuenta = cuentaRepository.findById(command.cuentaId())
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cuenta no encontrada por ID: '%s'", command.cuentaId())));

        Movimiento movimiento = new Movimiento(
                UUID.randomUUID(),
                cuenta.getId(),
                LocalDateTime.now(),
                command.tipo(),
                command.valor()
        );

        cuenta.aplicarMovimiento(movimiento);

        cuentaRepository.save(cuenta);
        return movimientoRepository.save(movimiento);
    }

}
