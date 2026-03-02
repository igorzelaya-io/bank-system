package com.example.bankservice.infrastructure.web.controller;


import com.example.bankservice.application.port.in.create.CreateMovimientoUseCase;
import com.example.bankservice.application.port.in.create.command.CreateMovimientoCommand;
import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.web.dto.request.CreateMovimientoRequest;
import com.example.bankservice.infrastructure.web.dto.response.MovimientoResponse;
import com.example.bankservice.infrastructure.web.mapper.MovimientoWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final CreateMovimientoUseCase createMovimientoUseCase;
    private final MovimientoWebMapper mapper;

    @PostMapping
    public ResponseEntity<MovimientoResponse> create(@Valid @RequestBody CreateMovimientoRequest request) {

        CreateMovimientoCommand command = mapper.toCommand(request);
        Movimiento movimiento = createMovimientoUseCase.create(command);

        MovimientoResponse response = mapper.toResponse(movimiento);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}