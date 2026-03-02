package com.example.bankservice.infrastructure.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateClienteRequest(
    @NotBlank String nombre,
    String genero,
    Integer edad,
    @NotBlank String identificacion,
    String direccion,
    String telefono,
    @NotBlank String clienteId,
    @NotBlank String password

){ }
