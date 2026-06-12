package com.janampa.ms_lib_libros.service.impl;

import com.janampa.ms_lib_libros.dto.AuthorRequest;
import com.janampa.ms_lib_libros.dto.AuthorResponse;
import com.janampa.ms_lib_libros.entity.Author;
import com.janampa.ms_lib_libros.mapper.AuthorMapper;
import com.janampa.ms_lib_libros.repository.AuthorRepository;
import com.janampa.ms_lib_libros.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    @Transactional
    public AuthorResponse create(AuthorRequest request) {
        Author author = mapper.toEntity(request);
        return mapper.toResponse(repository.save(author));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Override
    @Transactional
    public AuthorResponse update(Long id, AuthorRequest request) {
        Author author = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        author.setNombres(request.getNombres());
        author.setApellidos(request.getApellidos());
        author.setNacionalidad(request.getNacionalidad());

        return mapper.toResponse(repository.save(author));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado");
        }
        repository.deleteById(id);
    }
}