package com.janampa.ms_lib_prestamos.controller;

import com.janampa.ms_lib_prestamos.dto.LoanDetailRequest;
import com.janampa.ms_lib_prestamos.dto.LoanDetailResponse;
import com.janampa.ms_lib_prestamos.service.LoanDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loan-details")
@RequiredArgsConstructor
public class LoanDetailController {

    private final LoanDetailService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanDetailResponse create(@Valid @RequestBody LoanDetailRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<LoanDetailResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LoanDetailResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}