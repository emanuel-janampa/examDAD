package com.janampa.ms_lib_libros.service;

import com.janampa.ms_lib_libros.dto.CategoryRequest;
import com.janampa.ms_lib_libros.dto.CategoryResponse;
import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryRequest request);
    List<CategoryResponse> getAll();
    CategoryResponse getById(Long id);
    CategoryResponse update(Long id, CategoryRequest request);
    void delete(Long id);
}