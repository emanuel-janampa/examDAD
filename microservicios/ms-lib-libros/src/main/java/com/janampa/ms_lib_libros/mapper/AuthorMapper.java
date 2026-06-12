package com.janampa.ms_lib_libros.mapper;

import com.janampa.ms_lib_libros.dto.AuthorRequest;
import com.janampa.ms_lib_libros.dto.AuthorResponse;
import com.janampa.ms_lib_libros.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntity(AuthorRequest request) {
        return Author.builder()
                .nombres(request.getNombres())
                .apellidos(request.getApellidos())
                .nacionalidad(request.getNacionalidad())
                .build();
    }

    public AuthorResponse toResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .nombres(author.getNombres())
                .apellidos(author.getApellidos())
                .nacionalidad(author.getNacionalidad())
                .build();
    }
}