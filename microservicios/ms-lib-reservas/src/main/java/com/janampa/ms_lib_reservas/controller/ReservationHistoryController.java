package com.janampa.ms_lib_reservas.controller;

import com.janampa.ms_lib_reservas.dto.HistoryRequest;
import com.janampa.ms_lib_reservas.dto.HistoryResponse;
import com.janampa.ms_lib_reservas.service.ReservationHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservation-histories")
@RequiredArgsConstructor
public class ReservationHistoryController {

    private final ReservationHistoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistoryResponse create(@Valid @RequestBody HistoryRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<HistoryResponse> getAll() {
        return service.getAll();
    }
}