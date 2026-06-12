package com.janampa.ms_lib_libros.repository;

import com.janampa.ms_lib_libros.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}