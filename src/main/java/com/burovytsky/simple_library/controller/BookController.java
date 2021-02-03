package com.burovytsky.simple_library.controller;

import com.burovytsky.simple_library.model.Book;
import com.burovytsky.simple_library.model.User;
import com.burovytsky.simple_library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<Book> findAll() {
        return new ArrayList<>(this.libraryService.getAllBooks());
    }

    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(
                this.libraryService.addBook(book),
                HttpStatus.CREATED
        );
    }

}
