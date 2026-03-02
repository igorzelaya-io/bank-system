package com.example.bankservice.infrastructure.web.controller;

import com.example.bankservice.application.port.in.create.CreateCuentaUseCase;
import com.example.bankservice.application.port.in.delete.DeleteCuentaUseCase;
import com.example.bankservice.application.port.in.get.FindCuentaUseCase;
import com.example.bankservice.application.port.in.update.UpdateCuentaUseCase;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.infrastructure.web.dto.request.CreateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.response.CuentaResponse;
import com.example.bankservice.infrastructure.web.mapper.CuentaWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cuentas")
public class CuentaController {

    private final CreateCuentaUseCase createCuentaUseCase;
    private final UpdateCuentaUseCase updateCuentaUseCase;
    private final DeleteCuentaUseCase deleteCuentaUseCase;
    private final FindCuentaUseCase findCuentaUseCase;

    private final CuentaWebMapper mapper;

    @PostMapping
    public ResponseEntity<CuentaResponse> create(
            @Valid @RequestBody CreateCuentaRequest request) {

        Cuenta cuenta = createCuentaUseCase.create(
                mapper.toCreateCommand(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(cuenta));
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> update(
            @PathVariable String numeroCuenta,
            @Valid @RequestBody UpdateCuentaRequest request) {

        Cuenta cuenta = updateCuentaUseCase.update(
                numeroCuenta,
                mapper.toUpdateCommand(request));

        return ResponseEntity.ok(mapper.toResponse(cuenta));
    }

    @DeleteMapping("/{numeroCuenta}")
    public ResponseEntity<Void> delete(
            @PathVariable String numeroCuenta) {

        deleteCuentaUseCase.delete(numeroCuenta);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> findByNumero(
            @PathVariable String numeroCuenta) {

        Cuenta cuenta = findCuentaUseCase.findByNumeroCuenta(numeroCuenta);

        return ResponseEntity.ok(mapper.toResponse(cuenta));
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponse>> findAll(@RequestParam(required = false, value = "search")
                                                            final String keyword) {

        if(keyword == null) {
            final List<CuentaResponse> response = mapper.toResponseList(findCuentaUseCase.findAll());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(mapper.toResponseList(findCuentaUseCase.findAllByKeyword(keyword)));
    }
}