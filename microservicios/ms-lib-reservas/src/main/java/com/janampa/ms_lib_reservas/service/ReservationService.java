package com.janampa.ms_lib_reservas.service;

import com.janampa.ms_lib_reservas.dto.ReservationRequest;
import com.janampa.ms_lib_reservas.dto.ReservationResponse;
import java.util.List;

public interface ReservationService {
    ReservationResponse create(ReservationRequest request);
    List<ReservationResponse> getAll();
    ReservationResponse getById(Long id);
    ReservationResponse updateStatus(Long id, String status);
    void delete(Long id);
}