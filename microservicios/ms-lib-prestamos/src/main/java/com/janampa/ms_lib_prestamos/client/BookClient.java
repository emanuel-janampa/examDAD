package com.janampa.ms_lib_prestamos.client;

import com.janampa.ms_lib_prestamos.dto.external.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-lib-libros")
public interface BookClient {

    @GetMapping("/api/books/{id}")
    BookDTO getBookById(@PathVariable("id") Long id);

    @PutMapping("/api/books/{id}/decrease-stock")
    void decreaseStock(
            @PathVariable("id") Long id,
            @RequestParam("amount") int amount);
}