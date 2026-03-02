package com.example.reportsystem.application.port.service;

import com.example.reportsystem.application.port.in.GeneratePdfUseCase;
import com.example.reportsystem.application.port.in.GenerateReportUseCase;
import com.example.reportsystem.infrastructure.web.dto.CuentaReport;
import com.example.reportsystem.infrastructure.web.dto.ReportResponse;
import com.lowagie.text.pdf.PdfPTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GeneratePdfService implements GeneratePdfUseCase {

    private final GenerateReportUseCase generateReportUseCase;

    @Override
    public byte[] generatePdf(String clienteId, LocalDateTime from, LocalDateTime to) throws IOException {

        ReportResponse report = generateReportUseCase.generate(clienteId, from, to);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            com.lowagie.text.Document document = new com.lowagie.text.Document();
            com.lowagie.text.pdf.PdfWriter.getInstance(document, baos);

            document.open();

            document.add(new com.lowagie.text.Paragraph("Reporte Cliente: " + report.clienteId()));
            document.add(new com.lowagie.text.Paragraph("Nombre: " + report.nombreCliente()));
            document.add(new com.lowagie.text.Paragraph(" "));

            for (var cuenta : report.cuentas()) {
                document.add(new com.lowagie.text.Paragraph("Cuenta: " + cuenta.numeroCuenta() +
                        " | Saldo Actual: " + cuenta.saldoActual()));

                PdfPTable table = getPdfPTable(cuenta);

                document.add(table);
                document.add(new com.lowagie.text.Paragraph(" "));
            }

            document.close();
            return baos.toByteArray();
        }
    }

    private static PdfPTable getPdfPTable(CuentaReport cuenta) {
        PdfPTable table = new PdfPTable(4);
        table.addCell("Fecha");
        table.addCell("Tipo");
        table.addCell("Valor");
        table.addCell("Saldo Restante");

        for (var mov : cuenta.movimientos()) {
            table.addCell(mov.fecha().toString());
            table.addCell(mov.tipo());
            table.addCell(mov.valor().toString());
            table.addCell(mov.saldoRestante().toString());
        }
        return table;
    }
}
