package com.janampa.ms_lib_libros.service.impl;

import com.janampa.ms_lib_libros.dto.CategoryRequest;
import com.janampa.ms_lib_libros.dto.CategoryResponse;
import com.janampa.ms_lib_libros.entity.Category;
import com.janampa.ms_lib_libros.mapper.CategoryMapper;
import com.janampa.ms_lib_libros.repository.CategoryRepository;
import com.janampa.ms_lib_libros.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    @Transactional
    public CategoryResponse create(CategoryRequest request) {
        Category category = mapper.toEntity(request);
        return mapper.toResponse(repository.save(category));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    @Transactional
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        category.setNombre(request.getNombre());
        category.setDescripcion(request.getDescripcion());

        return mapper.toResponse(repository.save(category));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada");
        }
        repository.deleteById(id);
    }
}