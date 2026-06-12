package com.janampa.ms_lib_prestamos.service;

import com.janampa.ms_lib_prestamos.dto.LoanDetailRequest;
import com.janampa.ms_lib_prestamos.dto.LoanDetailResponse;
import java.util.List;

public interface LoanDetailService {
    LoanDetailResponse create(LoanDetailRequest request);
    List<LoanDetailResponse> getAll();
    LoanDetailResponse getById(Long id);
    void delete(Long id);
}