package com.programacion4.unidad4ej5.feature.pago.service;

import com.programacion4.unidad4ej5.feature.pago.dtos.request.PagoRequestDTO;
import com.programacion4.unidad4ej5.feature.pago.dtos.response.PagoResponseDTO;
import com.programacion4.unidad4ej5.feature.pago.model.Pago;
import com.programacion4.unidad4ej5.feature.pago.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    private static final List<String> TIPOS_PAGO_VÁLIDOS = Arrays.asList(
        "EFECTIVO", "DEBITO", "CREDITO", "TRANSFERENCIA"
    );

    public PagoResponseDTO registrarPago(PagoRequestDTO pagoRequestDTO) {
        // Validate tipo de pago
        if (!TIPOS_PAGO_VÁLIDOS.contains(pagoRequestDTO.getTipoPago())) {
            throw new IllegalArgumentException(
                "Tipo de pago inválido. Valores aceptados: " + String.join(", ", TIPOS_PAGO_VÁLIDOS)
            );
        }

        // Check for duplicate transaction code
        if (pagoRepository.findByCodigoTransaccion(pagoRequestDTO.getCodigoTransaccion()).isPresent()) {
            throw new IllegalArgumentException("El código de transacción ya existe");
        }

        // Create and save Pago
        Pago pago = Pago.builder()
            .monto(pagoRequestDTO.getMonto())
            .codigoTransaccion(pagoRequestDTO.getCodigoTransaccion())
            .fechaVencimiento(pagoRequestDTO.getFechaVencimiento())
            .tipoPago(pagoRequestDTO.getTipoPago())
            .estado("REGISTRADO")
            .build();

        Pago pagGuardado = pagoRepository.save(pago);

        return convertToResponseDTO(pagGuardado);
    }

    private PagoResponseDTO convertToResponseDTO(Pago pago) {
        return PagoResponseDTO.builder()
            .id(pago.getId())
            .monto(pago.getMonto())
            .codigoTransaccion(pago.getCodigoTransaccion())
            .fechaVencimiento(pago.getFechaVencimiento())
            .tipoPago(pago.getTipoPago())
            .fechaRegistro(pago.getFechaRegistro())
            .estado(pago.getEstado())
            .build();
    }

}
