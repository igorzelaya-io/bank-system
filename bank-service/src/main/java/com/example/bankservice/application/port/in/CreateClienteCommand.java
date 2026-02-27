package com.example.bankservice.application.port.in;

public record CreateClienteCommand(
        String nombre,
        String genero,
        Integer edad,
        String identificacion,
        String direccion,
        String telefono,
        String clienteId,
        String password
) {}
