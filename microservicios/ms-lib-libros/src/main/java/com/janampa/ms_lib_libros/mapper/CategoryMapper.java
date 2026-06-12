package com.janampa.ms_lib_libros.mapper;

import com.janampa.ms_lib_libros.dto.CategoryRequest;
import com.janampa.ms_lib_libros.dto.CategoryResponse;
import com.janampa.ms_lib_libros.entity.Category;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {
        return Category.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .build();
    }

    public CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .nombre(category.getNombre())
                .descripcion(category.getDescripcion())
                .build();
    }
}