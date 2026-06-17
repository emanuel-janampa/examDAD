package com.janampa.ms_lib_reservas.service.impl;

import com.janampa.ms_lib_reservas.client.BookClient;
import com.janampa.ms_lib_reservas.dto.ReservationRequest;
import com.janampa.ms_lib_reservas.dto.ReservationResponse;
import com.janampa.ms_lib_reservas.dto.external.BookDTO;
import com.janampa.ms_lib_reservas.entity.Reservation;
import com.janampa.ms_lib_reservas.mapper.ReservationMapper;
import com.janampa.ms_lib_reservas.repository.ReservationRepository;
import com.janampa.ms_lib_reservas.service.ReservationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;
    private final BookClient bookClient;

    @Override
    @Transactional
    @CircuitBreaker(name = "booksCB", fallbackMethod = "fallbackCreateReservation")
    public ReservationResponse create(ReservationRequest request) {

        BookDTO book = bookClient.getBookById(request.getIdLibro());

        if (book == null) {
            throw new RuntimeException("No se puede reservar: El libro no existe en el catálogo.");
        }

        Reservation reservation = mapper.toEntity(request);

        if (reservation.getEstado() == null) {
            reservation.setEstado("PENDIENTE");
        }

        return mapper.toResponse(repository.save(reservation));
    }

    public ReservationResponse fallbackCreateReservation(ReservationRequest request, Throwable e) {
        throw new RuntimeException("El sistema de Catálogo/Libros no se encuentra disponible. " +
                "La reserva no se pudo procesar para evitar inconsistencias en el sistema.");
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