package com.janampa.ms_lib_reservas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long idUsuario;

    @NotNull(message = "El ID del libro es obligatorio")
    private Long idLibro;

    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva;

    @NotNull(message = "La fecha de expiración es obligatoria")
    private LocalDateTime fechaExpiracion;

    @NotBlank(message = "El estado inicial es obligatorio")
    private String estado; // PENDIENTE
}