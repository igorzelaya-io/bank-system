package com.example.reportsystem.infrastructure.web.client;

import com.example.reportsystem.infrastructure.web.dto.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "${bank-service.url}")
public interface ClienteClient {
    @GetMapping("/api/v1/clientes/{clienteId}")
    ClienteResponse getCliente(@PathVariable String clienteId);
}