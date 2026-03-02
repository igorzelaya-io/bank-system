package com.example.bankservice.infrastructure.web.controller;

import com.example.bankservice.application.port.in.create.CreateCuentaUseCase;
import com.example.bankservice.application.port.in.delete.DeleteCuentaUseCase;
import com.example.bankservice.application.port.in.get.FindClienteUseCase;
import com.example.bankservice.application.port.in.get.FindCuentaUseCase;
import com.example.bankservice.application.port.in.update.UpdateCuentaUseCase;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cuenta;
import com.example.bankservice.infrastructure.web.dto.request.CreateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateCuentaRequest;
import com.example.bankservice.infrastructure.web.dto.response.CuentaResponse;
import com.example.bankservice.infrastructure.web.mapper.CuentaWebMapper;
import com.example.bankservice.support.annotation.BankControllerTest;
import com.example.bankservice.support.mother.cuenta.CuentaMother;
import com.example.bankservice.support.mother.cuenta.CuentaRequestMother;
import com.example.bankservice.support.mother.cuenta.CuentaResponseMother;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@BankControllerTest
@WebMvcTest(controllers = CuentaController.class)
class CuentaControllerTest extends AbstractControllerTest {

    @MockBean
    private CreateCuentaUseCase createCuentaUseCase;

    @MockBean
    private UpdateCuentaUseCase updateCuentaUseCase;

    @MockBean
    private DeleteCuentaUseCase deleteCuentaUseCase;

    @MockBean
    private FindCuentaUseCase findCuentaUseCase;

    @MockBean
    private FindClienteUseCase findClienteUseCase;

    @MockBean
    private CuentaWebMapper mapper;

    @Test
    void createCuenta_returns201() throws Exception {

        CreateCuentaRequest request = CuentaRequestMother.validCreate();
        Cuenta cuenta = CuentaMother.valid();
        CuentaResponse response = CuentaResponseMother.validResponse();

        when(mapper.toCreateCommand(any())).thenReturn(null);
        when(createCuentaUseCase.create(any())).thenReturn(cuenta);
        when(mapper.toResponse(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroCuenta").value(response.numeroCuenta()));
    }

    @Test
    void createCuenta_returns400_whenInvalid() throws Exception {

        CreateCuentaRequest invalid = CuentaRequestMother.invalidCreate();

        mockMvc.perform(post("/api/v1/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateCuenta_returns200() throws Exception {

        UpdateCuentaRequest request = CuentaRequestMother.validUpdate();
        CuentaResponse response = CuentaResponseMother.validResponse();

        when(updateCuentaUseCase.update(any(), any()))
                .thenReturn(CuentaMother.valid());

        when(mapper.toResponse(any())).thenReturn(response);

        mockMvc.perform(put("/api/v1/cuentas/ACC-001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void updateCuenta_failure_invalidRequest() throws Exception {
        UUID cuentaId = UUID.randomUUID();
        UpdateCuentaRequest request = CuentaRequestMother.invalidUpdate();

        mockMvc.perform(put("/api/v1/cuentas/{clienteId}", cuentaId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }



    @Test
    void deleteCuenta_returns204() throws Exception {

        mockMvc.perform(delete("/api/v1/cuentas/ACC-001"))
                .andExpect(status().isNoContent());
    }

    @Test
    void findCuenta_returns200() throws Exception {

        when(findCuentaUseCase.findByNumeroCuenta(any()))
                .thenReturn(CuentaMother.valid());

        when(mapper.toResponse(any()))
                .thenReturn(CuentaResponseMother.validResponse());

        mockMvc.perform(get("/api/v1/cuentas/ACC-001"))
                .andExpect(status().isOk());
    }

    @Test
    void findByClientId_failure_notFound() throws Exception {
        String clientId = "33333333-3333-3333-3333-333333333333";

        when(findClienteUseCase.findByClienteId(clientId))
                .thenThrow(new ResourceNotFoundException("Cliente not found"));

        mockMvc.perform(get("/cuentas/{clientId}", clientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}