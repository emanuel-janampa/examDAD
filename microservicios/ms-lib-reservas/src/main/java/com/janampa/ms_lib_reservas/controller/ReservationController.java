package com.janampa.ms_lib_reservas.controller;

import com.janampa.ms_lib_reservas.dto.ReservationRequest;
import com.janampa.ms_lib_reservas.dto.ReservationResponse;
import com.janampa.ms_lib_reservas.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse create(@Valid @RequestBody ReservationRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ReservationResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReservationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}/status")
    public ReservationResponse updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}