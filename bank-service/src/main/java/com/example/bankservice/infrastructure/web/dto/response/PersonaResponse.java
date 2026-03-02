package com.example.bankservice.infrastructure.web.dto.response;

import java.util.UUID;

public record PersonaResponse(
        UUID id,
        String nombre,
        String genero,
        Integer edad,
        String identificacion,
        String direccion,
        String telefono
) {}