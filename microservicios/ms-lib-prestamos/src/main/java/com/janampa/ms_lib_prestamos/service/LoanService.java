package com.janampa.ms_lib_prestamos.service;

import com.janampa.ms_lib_prestamos.dto.LoanRequest;
import com.janampa.ms_lib_prestamos.dto.LoanResponse;
import java.util.List;

public interface LoanService {
    LoanResponse create(LoanRequest request);
    List<LoanResponse> getAll();
    LoanResponse getById(Long id);
    LoanResponse update(Long id, LoanRequest request);
    void delete(Long id);
}