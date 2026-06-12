package com.janampa.ms_lib_prestamos.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResponse {
    private Long id;
    private Long loanId;
    private LocalDateTime fechaDevolucion;
    private String observacion;
    private String estado;
}