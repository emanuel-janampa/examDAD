package com.janampa.ms_lib_reservas.service;

import com.janampa.ms_lib_reservas.dto.HistoryRequest;
import com.janampa.ms_lib_reservas.dto.HistoryResponse;
import java.util.List;

public interface ReservationHistoryService {
    HistoryResponse create(HistoryRequest request);
    List<HistoryResponse> getAll();
}