package com.example.bankservice.support.mother;

import com.example.bankservice.application.port.in.UpdateClienteCommand;

public final class UpdateClienteCommandMother {

    private UpdateClienteCommandMother() {}

    public static UpdateClienteCommand validCommand() {
        return new UpdateClienteCommand(
                "Updated Name",
                "F",
                35,
                "0801199012345",
                "Updated Address",
                "7777-7777",
                "newPassword",
                true
        );
    }

}
