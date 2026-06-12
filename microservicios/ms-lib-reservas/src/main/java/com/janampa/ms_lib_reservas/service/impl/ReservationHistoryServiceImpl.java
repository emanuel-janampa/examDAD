package com.janampa.ms_lib_reservas.service.impl;

import com.janampa.ms_lib_reservas.dto.HistoryRequest;
import com.janampa.ms_lib_reservas.dto.HistoryResponse;
import com.janampa.ms_lib_reservas.entity.Reservation;
import com.janampa.ms_lib_reservas.entity.ReservationHistory;
import com.janampa.ms_lib_reservas.mapper.ReservationHistoryMapper;
import com.janampa.ms_lib_reservas.repository.ReservationRepository;
import com.janampa.ms_lib_reservas.repository.ReservationHistoryRepository;
import com.janampa.ms_lib_reservas.service.ReservationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    private final ReservationHistoryRepository repository;
    private final ReservationRepository reservationRepository;
    private final ReservationHistoryMapper mapper;

    @Override
    @Transactional
    public HistoryResponse create(HistoryRequest request) {
        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reserva principal no encontrada"));

        // Automatización: Al registrar un historial, actualizamos el estado de la reserva maestra
        reservation.setEstado(request.getEstadoNuevo().toUpperCase());
        reservationRepository.save(reservation);

        ReservationHistory history = mapper.toEntity(request, reservation);
        return mapper.toResponse(repository.save(history));
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoryResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }
}