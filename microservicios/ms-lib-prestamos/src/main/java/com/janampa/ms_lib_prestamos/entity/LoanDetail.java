package com.janampa.ms_lib_prestamos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Loan loan;

    @Column(name = "id_libro", nullable = false)
    private Long idLibro;

    @Column(nullable = false)
    private Integer cantidad;
}