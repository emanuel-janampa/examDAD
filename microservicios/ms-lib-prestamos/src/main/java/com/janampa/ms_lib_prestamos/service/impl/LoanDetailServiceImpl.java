package com.janampa.ms_lib_prestamos.service.impl;

import com.janampa.ms_lib_prestamos.client.BookClient;
import com.janampa.ms_lib_prestamos.dto.LoanDetailRequest;
import com.janampa.ms_lib_prestamos.dto.LoanDetailResponse;
import com.janampa.ms_lib_prestamos.dto.external.BookDTO;
import com.janampa.ms_lib_prestamos.entity.Loan;
import com.janampa.ms_lib_prestamos.entity.LoanDetail;
import com.janampa.ms_lib_prestamos.mapper.LoanDetailMapper;
import com.janampa.ms_lib_prestamos.repository.LoanRepository;
import com.janampa.ms_lib_prestamos.repository.LoanDetailRepository;
import com.janampa.ms_lib_prestamos.service.LoanDetailService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    private final BookClient bookClient;

    @Override
    @Transactional
    @CircuitBreaker(name = "booksCB", fallbackMethod = "fallbackCreateLoanDetail")
    public LoanDetailResponse create(LoanDetailRequest request) {

        Loan loan = loanRepository.findById(request.getLoanId())
                .orElseThrow(() -> new RuntimeException("Préstamo maestro no encontrado"));

        BookDTO book = bookClient.getBookById(request.getIdLibro());

        if (book == null) {
            throw new RuntimeException("Libro no encontrado");
        }

        if (book.getStockDisponible() < request.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }

        bookClient.decreaseStock(request.getIdLibro(), request.getCantidad());

        LoanDetail detail = mapper.toEntity(request, loan);

        return mapper.toResponse(repository.save(detail));
    }

    public LoanDetailResponse fallbackCreateLoanDetail(LoanDetailRequest request, Throwable e) {
        throw new RuntimeException("El servicio de Catálogo/Libros no responde. " +
                "La transacción de préstamo fue cancelada de forma segura para proteger la consistencia.");
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