package com.example.bankservice.infrastructure.web.mapper;

import com.example.bankservice.application.port.in.create.command.CreateMovimientoCommand;
import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.web.dto.request.CreateMovimientoRequest;
import com.example.bankservice.infrastructure.web.dto.response.MovimientoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovimientoWebMapper {

    public CreateMovimientoCommand toCommand(CreateMovimientoRequest request) {
        return new CreateMovimientoCommand(
                request.cuentaId(),
                request.tipo(),
                request.valor()
        );
    }

    public MovimientoResponse toResponse(Movimiento movimiento) {
        return new MovimientoResponse(
                movimiento.getId(),
                movimiento.getCuentaId(),
                movimiento.getFecha(),
                movimiento.getTipo(),
                movimiento.getValor(),
                movimiento.getSaldoRestante()
        );
    }
}