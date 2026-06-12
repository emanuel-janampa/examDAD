package com.janampa.ms_lib_prestamos.service.impl;

import com.janampa.ms_lib_prestamos.dto.LoanRequest;
import com.janampa.ms_lib_prestamos.dto.LoanResponse;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.mapper.LoanMapper;
import com.janampa.ms_lib_prestamos.repository.LoanRepository;
import com.janampa.ms_lib_prestamos.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;
    private final LoanMapper mapper;

    @Override
    @Transactional
    public LoanResponse create(LoanRequest request) {
        Loan loan = mapper.toEntity(request);
        return mapper.toResponse(repository.save(loan));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LoanResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    @Override
    @Transactional
    public LoanResponse update(Long id, LoanRequest request) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.setIdUsuario(request.getIdUsuario());
        loan.setFechaPrestamo(request.getFechaPrestamo());
        loan.setFechaVencimiento(request.getFechaVencimiento());
        loan.setEstado(request.getEstado());

        return mapper.toResponse(repository.save(loan));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Préstamo no encontrado");
        }
        repository.deleteById(id);
    }
}