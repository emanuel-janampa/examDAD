package com.janampa.ms_lib_prestamos.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Long id;
    private Long idUsuario;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaVencimiento;
    private LocalDateTime fechaDevolucion;
    private String estado;
}