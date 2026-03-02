package com.example.bankservice.application.port.in.get;

import com.example.bankservice.domain.model.Movimiento;

import java.util.List;
import java.util.UUID;

public interface FindMovimientoUseCase {

    List<Movimiento> findByClienteId(UUID clienteId);

    List<Movimiento> findAll();

}
