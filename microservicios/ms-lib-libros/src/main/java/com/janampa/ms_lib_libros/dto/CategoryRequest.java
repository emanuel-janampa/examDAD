package com.janampa.ms_lib_libros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;

    private String descripcion;
}