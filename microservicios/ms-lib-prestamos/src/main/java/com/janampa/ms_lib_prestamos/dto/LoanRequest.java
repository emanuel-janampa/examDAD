package com.janampa.ms_lib_prestamos.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long idUsuario;

    @NotNull(message = "La fecha de préstamo es obligatoria")
    private LocalDateTime fechaPrestamo;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    private LocalDateTime fechaVencimiento;

    @NotBlank(message = "El estado inicial es obligatorio")
    private String estado; // Ejemplo: "ACTIVO"
}