package com.janampa.ms_lib_libros.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String nombre;
    private String descripcion;
}