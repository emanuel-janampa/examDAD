package com.janampa.ms_lib_libros.controller;

import com.janampa.ms_lib_libros.dto.BookRequest;
import com.janampa.ms_lib_libros.dto.BookResponse;
import com.janampa.ms_lib_libros.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@Valid @RequestBody BookRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<BookResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}