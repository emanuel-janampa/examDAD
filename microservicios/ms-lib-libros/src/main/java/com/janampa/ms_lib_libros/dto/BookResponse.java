package com.janampa.ms_lib_libros.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private String estado;
    private Long categoryId;
    private String categoryName;
    private Long authorId;
    private String authorFullName;
    private Integer stockTotal;
    private Integer stockDisponible;
}