package com.janampa.ms_lib_reservas.service.impl;

import com.janampa.ms_lib_reservas.dto.ReservationRequest;
import com.janampa.ms_lib_reservas.dto.ReservationResponse;
import com.janampa.ms_lib_reservas.entity.Reservation;
import com.janampa.ms_lib_reservas.mapper.ReservationMapper;
import com.janampa.ms_lib_reservas.repository.ReservationRepository;
import com.janampa.ms_lib_reservas.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    @Override
    @Transactional
    public ReservationResponse create(ReservationRequest request) {
        Reservation reservation = mapper.toEntity(request);
        return mapper.toResponse(repository.save(reservation));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReservationResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    @Transactional
    public ReservationResponse updateStatus(Long id, String status) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        
        reservation.setEstado(status.toUpperCase());
        return mapper.toResponse(repository.save(reservation));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        repository.deleteById(id);
    }
}