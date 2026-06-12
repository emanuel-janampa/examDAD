package com.janampa.ms_lib_prestamos.mapper;

import com.janampa.ms_lib_prestamos.dto.ReturnRequest;
import com.janampa.ms_lib_prestamos.dto.ReturnResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.entity.Return;
import org.springframework.stereotype.Component;

@Component
public class ReturnMapper {
    public Return toEntity(ReturnRequest request, Loan loan) {
        return Return.builder()
                .loan(loan)
                .fechaDevolucion(request.getFechaDevolucion())
                .observacion(request.getObservacion())
                .estado(request.getEstado())
                .build();
    }

    public ReturnResponse toResponse(Return entity) {
        return ReturnResponse.builder()
                .id(entity.getId())
                .loanId(entity.getLoan().getId())
                .fechaDevolucion(entity.getFechaDevolucion())
                .observacion(entity.getObservacion())
                .estado(entity.getEstado())
                .build();
    }
}