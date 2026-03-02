package com.example.bankservice.application.service;


import com.example.bankservice.application.port.in.update.command.UpdateCuentaCommand;
import com.example.bankservice.application.port.in.update.UpdateCuentaUseCase;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCuentaService implements UpdateCuentaUseCase {

    private final CuentaRepositoryPort cuentaRepository;

    @Override
    public Cuenta update(String numeroCuenta, UpdateCuentaCommand command) {

        Cuenta existent = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cuenta was not found for numero: '%s'", numeroCuenta)))
                .actualizarEstado(command.estado())
                .actualizarTipoCuenta(command.tipoCuenta());

        return cuentaRepository.save(existent);

    }
}
