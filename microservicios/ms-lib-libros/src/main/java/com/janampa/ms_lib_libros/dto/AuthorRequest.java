package com.janampa.ms_lib_libros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    private String nacionalidad;
}