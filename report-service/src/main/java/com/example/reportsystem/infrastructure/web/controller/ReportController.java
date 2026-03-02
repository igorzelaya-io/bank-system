package com.example.reportsystem.infrastructure.web.controller;


import com.example.reportsystem.application.port.in.GeneratePdfUseCase;
import com.example.reportsystem.application.port.in.GenerateReportUseCase;
import com.example.reportsystem.infrastructure.web.dto.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {

    private final GenerateReportUseCase generateReportUseCase;

    private final GeneratePdfUseCase generatePdfUseCase;

    @GetMapping
    public ResponseEntity<ReportResponse> getReport(
            @RequestParam String clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {

        return ResponseEntity.ok(generateReportUseCase.generate(clienteId, from, to));
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getReportPdf(
            @RequestParam String clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to
    ) throws IOException {

        byte[] pdf = generatePdfUseCase.generatePdf(clienteId, from, to);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}