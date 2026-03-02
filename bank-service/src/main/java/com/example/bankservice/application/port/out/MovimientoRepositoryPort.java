package com.example.bankservice.application.port.out;

import com.example.bankservice.domain.model.Movimiento;

import java.util.List;
import java.util.UUID;

public interface MovimientoRepositoryPort {

    Movimiento save(Movimiento movimiento);

    List<Movimiento> findAllByCuentaId(UUID clientId);

    List<Movimiento> findAll();

}
