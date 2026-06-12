package com.janampa.ms_lib_libros.service;

import com.janampa.ms_lib_libros.dto.BookRequest;
import com.janampa.ms_lib_libros.dto.BookResponse;
import java.util.List;

public interface BookService {
    BookResponse create(BookRequest request);
    List<BookResponse> getAll();
    BookResponse getById(Long id);
    BookResponse update(Long id, BookRequest request);
    void delete(Long id);
}