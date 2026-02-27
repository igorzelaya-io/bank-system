package com.example.bankservice.infrastructure.web.controller;

import com.example.bankservice.application.port.in.CreateClienteCommand;
import com.example.bankservice.application.port.in.CreateClienteUseCase;
import com.example.bankservice.application.port.in.DeleteClienteUseCase;
import com.example.bankservice.application.port.in.PatchClienteUseCase;
import com.example.bankservice.application.port.in.UpdateClienteCommand;
import com.example.bankservice.application.port.in.UpdateClienteUseCase;
import com.example.bankservice.domain.exception.ResourceNotFoundException;
import com.example.bankservice.domain.model.Cliente;
import com.example.bankservice.infrastructure.web.dto.request.CreateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.response.ClienteResponse;
import com.example.bankservice.infrastructure.web.mapper.ClienteWebMapper;
import com.example.bankservice.support.annotation.BankControllerTest;
import com.example.bankservice.support.mother.ClienteMother;
import com.example.bankservice.support.mother.ClienteRequestMother;
import com.example.bankservice.support.mother.ClienteResponseMother;
import com.example.bankservice.support.mother.CreateClienteCommandMother;
import com.example.bankservice.support.mother.UpdateClienteCommandMother;
import com.example.bankservice.support.mother.UpdateClienteMother;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@BankControllerTest
@WebMvcTest(controllers = ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateClienteUseCase createClienteUseCase;

    @MockBean
    private UpdateClienteUseCase updateClienteUseCase;

    @MockBean
    private DeleteClienteUseCase deleteClienteUseCase;

    @MockBean
    private PatchClienteUseCase patchClienteUseCase;

    @MockBean
    private ClienteWebMapper clienteWebMapper;

    @Test
    void createCliente_returns201() throws Exception {

        final Cliente cliente = ClienteMother.validCliente();
        final CreateClienteRequest request = ClienteRequestMother.validCreateRequest();

        final CreateClienteCommand command = CreateClienteCommandMother.validCommand();

        final ClienteResponse response = ClienteResponseMother.validResponse();

        when(createClienteUseCase.create(any())).thenReturn(cliente);
        when(clienteWebMapper.toCreateCommand(request)).thenReturn(command);
        when(clienteWebMapper.toResponse(any(Cliente.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.clienteId").value(response.clienteId()))
                .andExpect(jsonPath("$.persona.identificacion")
                        .value(response.persona().identificacion()));
    }

    @Test
    void createCliente_returns400_whenInvalidRequest() throws Exception {

        CreateClienteRequest invalidRequest = ClienteRequestMother.invalidCreateRequest();

        mockMvc.perform(post("/api/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title").value("Validation error"));
    }

    @Test
    void updateCliente_returns200() throws Exception {

        Cliente updated = ClienteMother.validCliente();
        UpdateClienteRequest request = UpdateClienteMother.validUpdateRequest();

        UpdateClienteCommand command = UpdateClienteCommandMother.validCommand();
        ClienteResponse response = ClienteResponseMother.validResponse();

        when(updateClienteUseCase.update(any(), any()))
                .thenReturn(updated);
        when(clienteWebMapper.toUpdateCommand(request)).thenReturn(command);
        when(clienteWebMapper.toResponse(any(Cliente.class))).thenReturn(response);

        mockMvc.perform(put("/api/v1/clientes/CLI-001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId").value(updated.clienteId()));
    }

    @Test
    void updateCliente_returns404_whenNotFound() throws Exception {

        UpdateClienteRequest request = UpdateClienteMother.validUpdateRequest();

        when(updateClienteUseCase.update(any(), any()))
                .thenThrow(new ResourceNotFoundException("Cliente not found"));

        mockMvc.perform(put("/api/v1/clientes/CLI-001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());
    }

    @Test
    void patchCliente_returns200() throws Exception {

        Cliente updated = ClienteMother.validCliente();

        when(patchClienteUseCase.patchEstado(any(), any()))
                .thenReturn(updated);

        mockMvc.perform(patch("/api/v1/clientes/CLI-001/estado")
                        .param("enabled", "false"))
                .andExpect(status().isOk());
    }

    @Test
    void patchCliente_returns404_whenNotFound() throws Exception {

        when(patchClienteUseCase.patchEstado(any(), any()))
                .thenThrow(new ResourceNotFoundException("Cliente not found"));

        mockMvc.perform(patch("/api/v1/clientes/NOT_EXIST/estado")
                        .param("enabled", "false"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteCliente_returns204() throws Exception {

        mockMvc.perform(delete("/api/v1/clientes/CLI-001"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteCliente_returns404_whenNotFound() throws Exception {

        doThrow(new ResourceNotFoundException("Cliente not found"))
                .when(deleteClienteUseCase)
                .delete(any());

        mockMvc.perform(delete("/api/v1/clientes/NOT_EXIST"))
                .andExpect(status().isNotFound());
    }

}
