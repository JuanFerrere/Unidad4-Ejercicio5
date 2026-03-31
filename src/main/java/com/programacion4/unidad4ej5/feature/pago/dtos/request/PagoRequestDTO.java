package com.programacion4.unidad4ej5.feature.pago.dtos.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoRequestDTO {

    @NotNull(message = "El monto es requerido")
    @DecimalMin(value = "1000.00", message = "El monto no puede ser menor a 1000.00")
    private Double monto;

    @NotBlank(message = "El código de transacción es requerido")
    @Pattern(
        regexp = "^PAY-[A-Z0-9]{4}-[A-Z0-9]{4}$",
        message = "El código de transacción debe seguir el patrón PAY-XXXX-XXXX"
    )
    private String codigoTransaccion;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @Future(message = "La fecha de vencimiento debe ser una fecha en el futuro")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El tipo de pago es requerido")
    private String tipoPago;

}
