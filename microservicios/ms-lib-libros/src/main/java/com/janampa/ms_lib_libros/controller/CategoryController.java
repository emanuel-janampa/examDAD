package com.janampa.ms_lib_libros.controller;

import com.janampa.ms_lib_libros.dto.CategoryRequest;
import com.janampa.ms_lib_libros.dto.CategoryResponse;
import com.janampa.ms_lib_libros.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@Valid @RequestBody CategoryRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable("id") Long id, @Valid @RequestBody CategoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}