package com.example.bankservice.application.port.out;

import com.example.bankservice.domain.model.Movimiento;

public interface MovimientoRepositoryPort {

    Movimiento save(Movimiento movimiento);

}
