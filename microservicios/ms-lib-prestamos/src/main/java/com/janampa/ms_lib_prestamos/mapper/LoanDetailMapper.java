package com.janampa.ms_lib_prestamos.mapper;

import com.janampa.ms_lib_prestamos.dto.LoanDetailRequest;
import com.janampa.ms_lib_prestamos.dto.LoanDetailResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.entity.LoanDetail;
import org.springframework.stereotype.Component;

@Component
public class LoanDetailMapper {
    public LoanDetail toEntity(LoanDetailRequest request, Loan loan) {
        return LoanDetail.builder()
                .loan(loan)
                .idLibro(request.getIdLibro())
                .cantidad(request.getCantidad())
                .build();
    }

    public LoanDetailResponse toResponse(LoanDetail detail) {
        return LoanDetailResponse.builder()
                .id(detail.getId())
                .loanId(detail.getLoan().getId())
                .idLibro(detail.getIdLibro())
                .cantidad(detail.getCantidad())
                .build();
    }
}