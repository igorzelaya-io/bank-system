package com.example.reportsystem.application.port.in;

import java.io.IOException;
import java.time.LocalDateTime;

public interface GeneratePdfUseCase {

    public byte[] generatePdf(String clienteId, LocalDateTime from, LocalDateTime to) throws IOException;


}
