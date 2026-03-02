package com.example.bankservice.support.mother.cliente;

import com.example.bankservice.infrastructure.web.dto.request.UpdateClienteRequest;

public final class UpdateClienteMother {

    public static UpdateClienteRequest validUpdateRequest() {

        return new UpdateClienteRequest("Updated Name", "F",
                Integer.valueOf(35), "0801199012345", "Updated Address", "7777-7777",
                "newPassword", true);

    }

}
