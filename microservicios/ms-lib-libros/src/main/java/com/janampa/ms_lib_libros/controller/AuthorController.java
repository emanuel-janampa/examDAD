package com.janampa.ms_lib_libros.controller;

import com.janampa.ms_lib_libros.dto.AuthorRequest;
import com.janampa.ms_lib_libros.dto.AuthorResponse;
import com.janampa.ms_lib_libros.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse create(@Valid @RequestBody AuthorRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<AuthorResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AuthorResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public AuthorResponse update(@PathVariable Long id, @Valid @RequestBody AuthorRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}