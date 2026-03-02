package com.example.reportsystem.infrastructure.web.dto;

import java.util.UUID;

public record ClienteResponse(
        UUID id,
        String nombre,
        String email
) {}