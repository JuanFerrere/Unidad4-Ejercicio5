package com.programacion4.unidad4ej5.feature.pago.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoResponseDTO {

    private Long id;

    private Double monto;

    private String codigoTransaccion;

    private LocalDate fechaVencimiento;

    private String tipoPago;

    private LocalDateTime fechaRegistro;

    private String estado;

}
