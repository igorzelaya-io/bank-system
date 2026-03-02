package com.example.bankservice.application.service;


import com.example.bankservice.application.port.in.delete.DeleteClienteUseCase;
import com.example.bankservice.application.port.out.ClienteRepositoryPort;
import com.example.bankservice.application.port.out.CuentaRepositoryPort;
import com.example.bankservice.domain.exception.BusinessException;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Cuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteClienteService implements DeleteClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;

    private final CuentaRepositoryPort cuentaRepository;

    @Override
    public void delete(String clienteId) {

        final Cliente existing = clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Cliente no fue encontrado por ID: %s", clienteId)));

        List<Cuenta> cuentas = cuentaRepository.findByClienteId(existing.id());

        if(!cuentas.isEmpty()) {
            boolean active = cuentas.stream()
                    .anyMatch(Cuenta::isEstado);

            if(active) {
                throw new BusinessException(String
                        .format("Cliente con ID: '%s' no puede ser desactivado mientras tenga cuentas activas.",
                                clienteId));
            }
        }

        final Cliente disabled = existing.changeEstado(false);

        clienteRepository.save(disabled);

    }
}
