package com.janampa.ms_lib_libros.service;

import com.janampa.ms_lib_libros.dto.AuthorRequest;
import com.janampa.ms_lib_libros.dto.AuthorResponse;
import java.util.List;

public interface AuthorService {
    AuthorResponse create(AuthorRequest request);
    List<AuthorResponse> getAll();
    AuthorResponse getById(Long id);
    AuthorResponse update(Long id, AuthorRequest request);
    void delete(Long id);
}