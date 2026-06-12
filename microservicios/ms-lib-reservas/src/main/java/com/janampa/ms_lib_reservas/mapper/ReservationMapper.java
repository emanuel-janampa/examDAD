package com.janampa.ms_lib_reservas.mapper;

import com.janampa.ms_lib_reservas.dto.ReservationRequest;
import com.janampa.ms_lib_reservas.dto.ReservationResponse;
import com.janampa.ms_lib_reservas.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation toEntity(ReservationRequest request) {
        return Reservation.builder()
                .idUsuario(request.getIdUsuario())
                .idLibro(request.getIdLibro())
                .fechaReserva(request.getFechaReserva())
                .fechaExpiracion(request.getFechaExpiracion())
                .estado(request.getEstado())
                .build();
    }

    public ReservationResponse toResponse(Reservation entity) {
        return ReservationResponse.builder()
                .id(entity.getId())
                .idUsuario(entity.getIdUsuario())
                .idLibro(entity.getIdLibro())
                .fechaReserva(entity.getFechaReserva())
                .fechaExpiracion(entity.getFechaExpiracion())
                .estado(entity.getEstado())
                .build();
    }
}