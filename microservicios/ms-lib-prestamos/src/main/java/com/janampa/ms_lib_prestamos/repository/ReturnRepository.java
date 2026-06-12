package com.janampa.ms_lib_prestamos.repository;

import com.janampa.ms_lib_prestamos.entity.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {
}