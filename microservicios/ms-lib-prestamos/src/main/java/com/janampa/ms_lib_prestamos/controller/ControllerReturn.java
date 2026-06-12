package com.janampa.ms_lib_prestamos.controller;

import com.janampa.ms_lib_prestamos.dto.ReturnRequest;
import com.janampa.ms_lib_prestamos.dto.ReturnResponse;
import com.janampa.ms_lib_prestamos.service.ReturnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/returns")
@RequiredArgsConstructor
public class ControllerReturn {

    private final ReturnService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReturnResponse create(@Valid @RequestBody ReturnRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ReturnResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ReturnResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }
}