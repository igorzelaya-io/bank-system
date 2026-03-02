package com.example.bankservice.support.mother.cliente;

import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.domain.model.Persona;

import java.util.UUID;

public final class ClienteMother {

    private ClienteMother() {}

    public static Cliente validCliente() {
        UUID id = UUID.randomUUID();

        Persona persona = new Persona(
                id,
                "Marianela Montalvo",
                "F",
                30,
                "0801199012345",
                "Tegucigalpa",
                "9999-9999"
        );

        return new Cliente(
                id,
                "CLI-001",
                "HASHED_PASSWORD",
                true,
                persona
        );
    }

    public static Cliente anotherValidCliente() {
        UUID id = UUID.randomUUID();

        Persona persona = new Persona(
                id,
                "Juan Perez",
                "M",
                40,
                "0801198012345",
                "San Pedro Sula",
                "8888-8888"
        );

        return new Cliente(
                id,
                "CLI-002",
                "HASHED_PASSWORD",
                true,
                persona
        );
    }

}
