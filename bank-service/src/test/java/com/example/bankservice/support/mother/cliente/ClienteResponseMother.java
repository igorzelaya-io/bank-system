package com.example.bankservice.support.mother.cliente;

import com.example.bankservice.infrastructure.web.dto.response.ClienteResponse;
import com.example.bankservice.infrastructure.web.dto.response.PersonaResponse;

import java.util.UUID;

public final class ClienteResponseMother {

    private ClienteResponseMother() {}

    public static ClienteResponse validResponse() {

        UUID id = UUID.randomUUID();

        return new ClienteResponse(
                id,
                "CLI-001",
                true,
                new PersonaResponse(
                        id,
                        "Marianela Montalvo",
                        "F",
                        30,
                        "0801199012345",
                        "Tegucigalpa",
                        "9999-9999"
                )
        );
    }
}
