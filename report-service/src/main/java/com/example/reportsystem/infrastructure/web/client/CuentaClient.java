package com.example.reportsystem.infrastructure.web.client;

import com.example.reportsystem.infrastructure.web.dto.CuentaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "cuenta-service", url = "${bank-service.url}")
public interface CuentaClient {

    @GetMapping("/api/v1/cuentas")
    List<CuentaResponse> findByClienteId(@RequestParam String clienteId);


}