package com.example.bankservice.infrastructure.web.controller;


import com.example.bankservice.application.port.in.create.CreateClienteUseCase;
import com.example.bankservice.application.port.in.create.command.CreateClienteCommand;
import com.example.bankservice.application.port.in.delete.DeleteClienteUseCase;
import com.example.bankservice.application.port.in.get.FindClienteUseCase;
import com.example.bankservice.application.port.in.patch.PatchClienteUseCase;
import com.example.bankservice.application.port.in.update.UpdateClienteUseCase;
import com.example.bankservice.application.port.in.update.command.UpdateClienteCommand;
import com.example.bankservice.infrastructure.web.dto.request.CreateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.request.UpdateClienteRequest;
import com.example.bankservice.infrastructure.web.dto.response.ClienteResponse;
import com.example.bankservice.infrastructure.web.mapper.ClienteWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;

    private final UpdateClienteUseCase updateClienteUseCase;

    private final PatchClienteUseCase patchClienteUseCase;

    private final DeleteClienteUseCase deleteClienteUseCase;

    private final FindClienteUseCase findClienteUseCase;

    private final ClienteWebMapper clienteWebMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findByKeyword(@RequestParam(required = false, value = "search")
                                                    String keyword) {
        if(keyword == null){
            return ResponseEntity.ok().body(clienteWebMapper.toResponseList(findClienteUseCase.findAll()));
        }
        return ResponseEntity.ok().body(clienteWebMapper.toResponseList(findClienteUseCase.findAllByKeyword(keyword)));

    }


    @GetMapping("/{clientId}")
    public ResponseEntity<ClienteResponse> findByClientId(@PathVariable("clientId") String clientId) {
        return ResponseEntity.ok()
                .body(clienteWebMapper.toResponse(findClienteUseCase
                        .findByClienteId(clientId)));
    }


    @PostMapping
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody CreateClienteRequest request) {

        final CreateClienteCommand command = clienteWebMapper.toCreateCommand(request);
        final ClienteResponse response = clienteWebMapper.toResponse(createClienteUseCase.create(command));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> update(@PathVariable("clienteId") final String clientId,
                                                  @RequestBody @Valid UpdateClienteRequest request) {

        final UpdateClienteCommand command = clienteWebMapper.toUpdateCommand(request);
        final ClienteResponse response = clienteWebMapper.toResponse(updateClienteUseCase.update(clientId, command));

        return ResponseEntity.ok(response);

    }

    @PatchMapping("/{clienteId}/estado")
    public ResponseEntity<ClienteResponse> patchEnabled(@PathVariable("clienteId") final String clienteId,
                                                        @RequestParam final Boolean enabled) {
        final ClienteResponse response = clienteWebMapper
                .toResponse(patchClienteUseCase.patchEstado(clienteId, enabled));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> softDelete(@PathVariable("clienteId") final String clienteId) {
        deleteClienteUseCase.delete(clienteId);
        return ResponseEntity.noContent().build();
    }
}
