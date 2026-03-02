package com.example.bankservice.infrastructure.web.dto.response;

import java.util.UUID;

public record ClienteResponse (
        UUID id,
        String clienteId,
        boolean estado,
        PersonaResponse persona
) {}