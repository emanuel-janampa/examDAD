package com.janampa.ms_lib_prestamos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRequest {

    @NotNull(message = "El ID del préstamo es obligatorio")
    private Long loanId;

    @NotNull(message = "La fecha de devolución es obligatoria")
    private LocalDateTime fechaDevolucion;

    private String observacion;

    @NotBlank(message = "El estado de la devolución es obligatorio")
    private String estado; // "A TIEMPO" o "ATRASADO"
}