package com.janampa.ms_lib_prestamos.dto.external;

import lombok.Data;

@Data
public class BookDTO {

    private Long idLibro;
    private String titulo;
    private Integer stockDisponible;

}