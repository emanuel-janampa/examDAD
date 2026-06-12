package com.janampa.ms_lib_libros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "autor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private String nacionalidad;
}