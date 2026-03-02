package com.example.reportsystem.application.port.service;

import com.example.reportsystem.application.port.in.GenerateReportUseCase;
import com.example.reportsystem.infrastructure.web.client.ClienteClient;
import com.example.reportsystem.infrastructure.web.client.CuentaClient;
import com.example.reportsystem.infrastructure.web.client.MovimientoClient;
import com.example.reportsystem.infrastructure.web.dto.CuentaReport;
import com.example.reportsystem.infrastructure.web.dto.MovimientoReport;
import com.example.reportsystem.infrastructure.web.dto.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerateReportService implements GenerateReportUseCase {

    private final ClienteClient clienteClient;
    private final CuentaClient cuentaClient;
    private final MovimientoClient movimientoClient;

    @Override
    public ReportResponse generate(String clienteId, LocalDateTime from, LocalDateTime to) {

        var cliente = clienteClient.getCliente(clienteId);
        var cuentas = cuentaClient.findByClienteId(clienteId);

        List<CuentaReport> cuentasReport = cuentas.stream().map(c -> {
            var movimientos = movimientoClient.findByCuentaId(c.id())
                    .stream()
                    .filter(m -> !m.fecha().isBefore(from) && !m.fecha().isAfter(to))
                    .map(mov -> new MovimientoReport(
                            mov.fecha(),
                            mov.tipo().toString(),
                            mov.valor(),
                            mov.saldoRestante()
                    ))
                    .toList();

            return new CuentaReport(
                    c.id(),
                    c.numeroCuenta(),
                    c.saldoActual(),
                    movimientos
            );
        }).toList();

        return new ReportResponse(cliente.id(), cliente.nombre(), cuentasReport);

    }


}
