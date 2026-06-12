package com.janampa.ms_lib_prestamos.service;

import com.janampa.ms_lib_prestamos.dto.ReturnRequest;
import com.janampa.ms_lib_prestamos.dto.ReturnResponse;
import java.util.List;

public interface ReturnService {
    ReturnResponse create(ReturnRequest request);
    List<ReturnResponse> getAll();
    ReturnResponse getById(Long id);
}