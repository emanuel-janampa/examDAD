package com.janampa.ms_lib_libros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Author author;

    @Column(name = "stock_total")
    private Integer stockTotal;

    @Column(name = "stock_disponible")
    private Integer stockDisponible;
}