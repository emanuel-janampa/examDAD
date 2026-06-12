package com.janampa.ms_lib_libros.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El ISBN es obligatorio")
    private String isbn;

    @NotNull(message = "El año de publicación es obligatorio")
    private Integer anioPublicacion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoryId;

    @NotNull(message = "El autor es obligatorio")
    private Long authorId;

    @NotNull(message = "El stock total es obligatorio")
    @Min(value = 0, message = "El stock total no puede ser negativo")
    private Integer stockTotal;
}