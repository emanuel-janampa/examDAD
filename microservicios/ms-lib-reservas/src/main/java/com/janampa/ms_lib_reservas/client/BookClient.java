package com.janampa.ms_lib_reservas.client;

import com.janampa.ms_lib_reservas.dto.external.BookDTO;
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