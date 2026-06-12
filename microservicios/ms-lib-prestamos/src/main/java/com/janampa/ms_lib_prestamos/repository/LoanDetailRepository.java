package com.janampa.ms_lib_prestamos.repository;

import com.janampa.ms_lib_prestamos.entity.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {
}