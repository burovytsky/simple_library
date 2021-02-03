package com.burovytsky.simple_library.controller;

import com.burovytsky.simple_library.model.User;
import com.burovytsky.simple_library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private final LibraryService libraryService;

    public UserController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<User> findAll() {
        return new ArrayList<>(this.libraryService.getAllUsers());
    }
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(
                this.libraryService.addUser(user),
                HttpStatus.CREATED
        );
    }
}
