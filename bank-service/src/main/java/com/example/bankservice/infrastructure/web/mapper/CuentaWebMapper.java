package com.example.bankservice.infrastructure.web.mapper;

import com.example.bankservice.application.port.in.create.command.CreateCuentaCommand;
import com.example.bankservice.application.port.in.update.command.UpdateCuentaCommand;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.infrastructure.web.dto.request.CreateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.response.CuentaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaWebMapper {

    CreateCuentaCommand toCreateCommand(CreateCuentaRequest request);

    UpdateCuentaCommand toUpdateCommand(UpdateCuentaRequest request);

    CuentaResponse toResponse(Cuenta cuenta);

}
