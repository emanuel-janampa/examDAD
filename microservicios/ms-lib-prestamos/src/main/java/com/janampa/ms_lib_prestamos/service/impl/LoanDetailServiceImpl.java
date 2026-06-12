package com.janampa.ms_lib_prestamos.service.impl;

import com.janampa.ms_lib_prestamos.dto.LoanDetailRequest;
import com.janampa.ms_lib_prestamos.dto.LoanDetailResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.entity.LoanDetail;
import com.janampa.ms_lib_prestamos.mapper.LoanDetailMapper;
import com.janampa.ms_lib_prestamos.repository.LoanRepository;
import com.janampa.ms_lib_prestamos.repository.LoanDetailRepository;
import com.janampa.ms_lib_prestamos.service.LoanDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanDetailServiceImpl implements LoanDetailService {

    private final LoanDetailRepository repository;
    private final LoanRepository loanRepository;
    private final LoanDetailMapper mapper;

    @Override
    @Transactional
    public LoanDetailResponse create(LoanDetailRequest request) {
        Loan loan = loanRepository.findById(request.getLoanId())
                .orElseThrow(() -> new RuntimeException("Préstamo maestro no encontrado"));

        LoanDetail detail = mapper.toEntity(request, loan);
        return mapper.toResponse(repository.save(detail));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanDetailResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LoanDetailResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Detalle no encontrado");
        }
        repository.deleteById(id);
    }
}