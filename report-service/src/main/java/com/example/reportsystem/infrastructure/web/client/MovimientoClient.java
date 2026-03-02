package com.example.reportsystem.infrastructure.web.client;

import com.example.reportsystem.infrastructure.web.dto.MovimientoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "movimiento-service", url = "${bank-service.url}")
public interface MovimientoClient {
    @GetMapping("/api/v1/movimientos")
    List<MovimientoResponse> findByCuentaId(@RequestParam UUID cuentaId);
}
