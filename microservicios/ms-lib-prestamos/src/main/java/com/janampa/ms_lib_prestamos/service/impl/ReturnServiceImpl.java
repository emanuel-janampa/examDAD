package com.janampa.ms_lib_prestamos.service.impl;

import com.janampa.ms_lib_prestamos.dto.ReturnRequest;
import com.janampa.ms_lib_prestamos.dto.ReturnResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.entity.Return;
import com.janampa.ms_lib_prestamos.mapper.ReturnMapper;
import com.janampa.ms_lib_prestamos.repository.LoanRepository;
import com.janampa.ms_lib_prestamos.repository.ReturnRepository;
import com.janampa.ms_lib_prestamos.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnServiceImpl implements ReturnService {

    private final ReturnRepository repository;
    private final LoanRepository loanRepository;
    private final ReturnMapper mapper;

    @Override
    @Transactional
    public ReturnResponse create(ReturnRequest request) {
        Loan loan = loanRepository.findById(request.getLoanId())
                .orElseThrow(() -> new RuntimeException("Préstamo asociado no encontrado"));

        // Al devolver, actualizamos también el estado del préstamo maestro a "DEVUELTO" y su fecha de devolución
        loan.setEstado("DEVUELTO");
        loan.setFechaDevolucion(request.getFechaDevolucion());
        loanRepository.save(loan);

        Return entity = mapper.toEntity(request, loan);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReturnResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReturnResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Registro de devolución no encontrado"));
    }
}