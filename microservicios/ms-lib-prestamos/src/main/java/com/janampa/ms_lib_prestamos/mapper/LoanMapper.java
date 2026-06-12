package com.janampa.ms_lib_prestamos.mapper;

import com.janampa.ms_lib_prestamos.dto.LoanRequest;
import com.janampa.ms_lib_prestamos.dto.LoanResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public Loan toEntity(LoanRequest request) {
        return Loan.builder()
                .idUsuario(request.getIdUsuario())
                .fechaPrestamo(request.getFechaPrestamo())
                .fechaVencimiento(request.getFechaVencimiento())
                .fechaDevolucion(null)
                .estado(request.getEstado())
                .build();
    }

    public LoanResponse toResponse(Loan loan) {
        return LoanResponse.builder()
                .id(loan.getId())
                .idUsuario(loan.getIdUsuario())
                .fechaPrestamo(loan.getFechaPrestamo())
                .fechaVencimiento(loan.getFechaVencimiento())
                .fechaDevolucion(loan.getFechaDevolucion())
                .estado(loan.getEstado())
                .build();
    }
}