package com.janampa.ms_lib_reservas.mapper;

import com.janampa.ms_lib_reservas.dto.HistoryRequest;
import com.janampa.ms_lib_reservas.dto.HistoryResponse;
import com.janampa.ms_lib_reservas.entity.Reservation;
import com.janampa.ms_lib_reservas.entity.ReservationHistory;
import org.springframework.stereotype.Component;

@Component
public class ReservationHistoryMapper {

    public ReservationHistory toEntity(HistoryRequest request, Reservation reservation) {
        return ReservationHistory.builder()
                .reservation(reservation)
                .estadoAnterior(request.getEstadoAnterior())
                .estadoNuevo(request.getEstadoNuevo())
                .fechaCambio(request.getFechaCambio())
                .observacion(request.getObservacion())
                .build();
    }

    public HistoryResponse toResponse(ReservationHistory entity) {
        return HistoryResponse.builder()
                .id(entity.getId())
                .reservationId(entity.getReservation().getId())
                .estadoAnterior(entity.getEstadoAnterior())
                .estadoNuevo(entity.getEstadoNuevo())
                .fechaCambio(entity.getFechaCambio())
                .observacion(entity.getObservacion())
                .build();
    }
}