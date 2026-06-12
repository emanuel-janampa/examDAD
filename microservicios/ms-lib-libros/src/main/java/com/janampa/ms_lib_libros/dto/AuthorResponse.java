package com.janampa.ms_lib_libros.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private Long id;
    private String nombres;
    private String apellidos;
    private String nacionalidad;
}