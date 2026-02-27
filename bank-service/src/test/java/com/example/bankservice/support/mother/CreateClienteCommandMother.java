package com.example.bankservice.support.mother;

import com.example.bankservice.application.port.in.CreateClienteCommand;

public final class CreateClienteCommandMother {
    private CreateClienteCommandMother() {}

    public static CreateClienteCommand validCommand() {
        return new CreateClienteCommand(
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
}
