package com.example.bankservice.domain.model;

import java.util.UUID;

public record Persona(
        UUID id,
        String nombre,
        String genero,
        Integer edad,
        String identificacion,
        String direccion,
        String telefono
) {}