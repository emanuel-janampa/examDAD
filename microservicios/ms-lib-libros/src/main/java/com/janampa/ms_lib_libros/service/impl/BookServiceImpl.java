package com.janampa.ms_lib_libros.service.impl;

import com.janampa.ms_lib_libros.dto.BookRequest;
import com.janampa.ms_lib_libros.dto.BookResponse;
import com.janampa.ms_lib_libros.entity.Author;
import com.janampa.ms_lib_libros.entity.Category;
import com.janampa.ms_lib_libros.entity.Book;
import com.janampa.ms_lib_libros.mapper.BookMapper;
import com.janampa.ms_lib_libros.repository.AuthorRepository;
import com.janampa.ms_lib_libros.repository.CategoryRepository;
import com.janampa.ms_lib_libros.repository.BookRepository;
import com.janampa.ms_lib_libros.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    @Override
    @Transactional
    public BookResponse create(BookRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Book book = mapper.toEntity(request, category, author);
        return mapper.toResponse(repository.save(book));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        book.setTitulo(request.getTitulo());
        book.setIsbn(request.getIsbn());
        book.setAnioPublicacion(request.getAnioPublicacion());
        book.setEstado(request.getEstado());
        book.setCategory(category);
        book.setAuthor(author);
        book.setStockTotal(request.getStockTotal());
        book.setStockDisponible(request.getStockTotal()); // Ajuste directo para el examen

        return mapper.toResponse(repository.save(book));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        repository.deleteById(id);
    }
}