package com.janampa.ms_lib_reservas.repository;

import com.janampa.ms_lib_reservas.entity.ReservationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationHistoryRepository extends JpaRepository<ReservationHistory, Long> {
}