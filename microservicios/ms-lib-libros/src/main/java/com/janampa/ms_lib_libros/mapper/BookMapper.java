package com.janampa.ms_lib_libros.mapper;

import com.janampa.ms_lib_libros.dto.BookRequest;
import com.janampa.ms_lib_libros.dto.BookResponse;
import com.janampa.ms_lib_libros.entity.Author;
import com.janampa.ms_lib_libros.entity.Category;
import com.janampa.ms_lib_libros.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequest request, Category category, Author author) {
        return Book.builder()
                .titulo(request.getTitulo())
                .isbn(request.getIsbn())
                .anioPublicacion(request.getAnioPublicacion())
                .estado(request.getEstado())
                .category(category)
                .author(author)
                .stockTotal(request.getStockTotal())
                .stockDisponible(request.getStockTotal()) // Al crear por primera vez, el disponible es igual al total
                .build();
    }

    public BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .titulo(book.getTitulo())
                .isbn(book.getIsbn())
                .anioPublicacion(book.getAnioPublicacion())
                .estado(book.getEstado())
                .categoryId(book.getCategory().getId())
                .categoryName(book.getCategory().getNombre())
                .authorId(book.getAuthor().getId())
                .authorFullName(book.getAuthor().getNombres() + " " + book.getAuthor().getApellidos())
                .stockTotal(book.getStockTotal())
                .stockDisponible(book.getStockDisponible())
                .build();
    }
}