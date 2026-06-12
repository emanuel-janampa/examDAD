package com.janampa.ms_lib_reservas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_libro", nullable = false)
    private Long idLibro;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDateTime fechaReserva;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDateTime fechaExpiracion;

    @Column(nullable = false)
    private String estado; // PENDIENTE, CONFIRMADA, CANCELADA, EXPIRADA
}