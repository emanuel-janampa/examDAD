package com.janampa.ms_lib_reservas.repository;

import com.janampa.ms_lib_reservas.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}