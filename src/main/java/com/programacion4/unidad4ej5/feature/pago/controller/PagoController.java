package com.programacion4.unidad4ej5.feature.pago.controller;

import com.programacion4.unidad4ej5.feature.pago.dtos.request.PagoRequestDTO;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDTO;
import com.programacion4.unidad4ej5.feature.pago.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoResponseDTO> registrarPago(@Valid @RequestBody PagoRequestDTO pagoRequestDTO) {
        PagoResponseDTO pagoResponseDTO = pagoService.registrarPago(pagoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoResponseDTO);
    }

}
