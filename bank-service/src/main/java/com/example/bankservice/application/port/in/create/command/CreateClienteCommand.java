package com.example.bankservice.application.port.in.create.command;

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
