package com.janampa.ms_lib_prestamos.controller;

import com.janampa.ms_lib_prestamos.dto.LoanRequest;
import com.janampa.ms_lib_prestamos.dto.LoanResponse;
import com.janampa.ms_lib_prestamos.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse create(@Valid @RequestBody LoanRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<LoanResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LoanResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public LoanResponse update(@PathVariable Long id, @Valid @RequestBody LoanRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}