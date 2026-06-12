package com.janampa.ms_lib_reservas.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private Long id;
    private Long idUsuario;
    private Long idLibro;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaExpiracion;
    private String estado;
}