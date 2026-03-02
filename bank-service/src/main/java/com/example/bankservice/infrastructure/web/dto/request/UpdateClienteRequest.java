package com.example.bankservice.infrastructure.web.dto.request;

public record UpdateClienteRequest(
    String nombre,

    String genero,

    Integer edad,

    String identificacion,

    String direccion,

    String telefono,

    String password,

    Boolean estado

){ }
