package com.janampa.ms_lib_reservas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reservation reservation;

    @Column(name = "estado_anterior", nullable = false)
    private String estadoAnterior;

    @Column(name = "estado_nuevo", nullable = false)
    private String estadoNuevo;

    @Column(name = "fecha_cambio", nullable = false)
    private LocalDateTime fechaCambio;

    private String observacion;
}