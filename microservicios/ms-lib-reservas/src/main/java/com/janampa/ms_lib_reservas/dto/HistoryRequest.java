package com.janampa.ms_lib_reservas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRequest {

    @NotNull(message = "El ID de la reserva es obligatorio")
    private Long reservationId;

    @NotBlank(message = "El estado anterior es obligatorio")
    private String estadoAnterior;

    @NotBlank(message = "El estado nuevo es obligatorio")
    private String estadoNuevo;

    @NotNull(message = "La fecha de cambio es obligatoria")
    private LocalDateTime fechaCambio;

    private String observacion;
}