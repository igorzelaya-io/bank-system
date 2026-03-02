package com.example.reportsystem.application.port.in;

import com.example.reportsystem.infrastructure.web.dto.ReportResponse;

import java.time.LocalDateTime;

public interface GenerateReportUseCase{
    ReportResponse generate(String clienteId, LocalDateTime from, LocalDateTime to);
}