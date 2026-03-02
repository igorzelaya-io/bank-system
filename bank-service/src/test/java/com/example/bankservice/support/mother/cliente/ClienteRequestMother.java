package com.example.bankservice.support.mother.cliente;

import com.example.bankservice.infrastructure.web.dto.request.CreateClienteRequest;

public final class ClienteRequestMother {

    public static CreateClienteRequest validCreateRequest() {
        return new CreateClienteRequest(
                "Marianela Montalvo",
                "F",
                30,
                "0801199012345",
                "Tegucigalpa",
                "9999-9999",
                "CLI-001",
                "password123"
        );
    }

    public static CreateClienteRequest invalidCreateRequest() {
        return new CreateClienteRequest(
                "",              // nombre invalid
                "F",
                30,
                "",              // identificacion invalid
                "Dir",
                "Tel",
                "",              // clienteId invalid
                ""              // password invalid
        );
    }
}
