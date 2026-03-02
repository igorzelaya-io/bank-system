package com.example.bankservice.infrastructure.web.controller;

import com.example.bankservice.application.port.in.create.CreateMovimientoUseCase;
import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.web.dto.request.CreateMovimientoRequest;
import com.example.bankservice.infrastructure.web.dto.response.MovimientoResponse;
import com.example.bankservice.infrastructure.web.mapper.MovimientoWebMapper;
import com.example.bankservice.support.annotation.BankControllerTest;
import com.example.bankservice.support.mother.movimiento.CreateMovimientoCommandMother;
import com.example.bankservice.support.mother.movimiento.CreateMovimientoRequestMother;
import com.example.bankservice.support.mother.movimiento.MovimientoMother;
import com.example.bankservice.support.mother.movimiento.MovimientoResponseMother;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@BankControllerTest
@WebMvcTest(controllers = MovimientoController.class)
class MovimientoControllerTest extends AbstractControllerTest {

    @MockBean
    private CreateMovimientoUseCase createMovimientoUseCase;

    @MockBean
    private MovimientoWebMapper mapper;

    @Test
    void createMovimiento_returns201() throws Exception {

        CreateMovimientoRequest request = CreateMovimientoRequestMother.valid();
        Movimiento movimiento = MovimientoMother.valid();
        MovimientoResponse response = MovimientoResponseMother.validResponse();

        when(mapper.toCommand(any())).thenReturn(CreateMovimientoCommandMother.validCommand());
        when(createMovimientoUseCase.create(any())).thenReturn(movimiento);
        when(mapper.toResponse(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/movimientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipo").value("RETIRO"))
                .andExpect(jsonPath("$.saldoRestante").value(1500));
    }

    @Test
    void createMovimiento_returns400_whenInvalid() throws Exception {
        CreateMovimientoRequest invalid = CreateMovimientoRequestMother.invalid();

        mockMvc.perform(post("/api/v1/movimientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest());
    }
}