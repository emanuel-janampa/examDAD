package com.janampa.ms_lib_prestamos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetailRequest {

    @NotNull(message = "El ID del préstamo es obligatorio")
    private Long loanId;

    @NotNull(message = "El ID del libro es obligatorio")
    private Long idLibro;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;
}