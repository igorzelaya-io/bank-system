package com.example.bankservice.application.service;

import com.example.bankservice.application.port.in.get.FindMovimientoUseCase;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.application.port.out.MovimientoRepositoryPort;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.domain.model.Movimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindMovimientoService implements FindMovimientoUseCase {

    private final MovimientoRepositoryPort movimientoRepository;
    private final CuentaRepositoryPort cuentaRepository;


    @Override
    public List<Movimiento> findByClienteId(UUID clienteId) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        return cuentas.stream()
                .flatMap(cuenta -> movimientoRepository.findAllByCuentaId(cuenta.getId()).stream())
                .toList();
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }
}