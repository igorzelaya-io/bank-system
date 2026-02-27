package com.example.bankservice.application.port.in;

public record UpdateClienteCommand(
        String nombre,
        String genero,
        Integer edad,
        String identificacion,
        String direccion,
        String telefono,
        String password,
        Boolean estado
) {}