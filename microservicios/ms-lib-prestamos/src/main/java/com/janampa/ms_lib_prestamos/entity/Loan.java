package com.janampa.ms_lib_prestamos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDateTime fechaPrestamo;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDateTime fechaVencimiento;

    @Column(name = "fecha_devolucion")
    private LocalDateTime fechaDevolucion;

    @Column(nullable = false)
    private String estado;
}