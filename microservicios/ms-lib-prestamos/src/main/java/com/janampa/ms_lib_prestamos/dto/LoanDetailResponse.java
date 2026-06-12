package com.janampa.ms_lib_prestamos.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetailResponse {
    private Long id;
    private Long loanId;
    private Long idLibro;
    private Integer cantidad;
}