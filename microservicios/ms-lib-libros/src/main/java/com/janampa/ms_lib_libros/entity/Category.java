package com.janampa.ms_lib_libros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;
}