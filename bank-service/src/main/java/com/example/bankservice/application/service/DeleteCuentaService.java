package com.example.bankservice.application.service;


import com.example.bankservice.application.port.in.delete.DeleteCuentaUseCase;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCuentaService implements DeleteCuentaUseCase {

    private final CuentaRepositoryPort cuentaRepository;

    @Override
    public void delete(String numeroCuenta) {

        Cuenta existent = cuentaRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cuenta no fue encontrada por numero: '%s'", numeroCuenta)))
                        .actualizarEstado(false);

        cuentaRepository.save(existent);
    }


}
