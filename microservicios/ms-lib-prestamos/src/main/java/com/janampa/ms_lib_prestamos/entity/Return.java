package com.janampa.ms_lib_prestamos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Loan loan;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDateTime fechaDevolucion;

    private String observacion;

    @Column(nullable = false)
    private String estado;
}