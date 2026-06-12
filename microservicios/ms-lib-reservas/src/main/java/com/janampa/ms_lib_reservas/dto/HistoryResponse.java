package com.janampa.ms_lib_reservas.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {
    private Long id;
    private Long reservationId;
    private String estadoAnterior;
    private String estadoNuevo;
    private LocalDateTime fechaCambio;
    private String observacion;
}