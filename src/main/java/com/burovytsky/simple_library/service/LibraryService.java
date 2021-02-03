package com.burovytsky.simple_library.service;

import com.burovytsky.simple_library.model.Book;
import com.burovytsky.simple_library.model.User;
import com.burovytsky.simple_library.repository.BookRepository;
import com.burovytsky.simple_library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LibraryService(BookRepository bookRepository, UserRepository users) {
        this.bookRepository = bookRepository;
        this.userRepository = users;
    }
    public Collection<Book> getAllBooks(){
        List<Book> rsl = new ArrayList<>();
        bookRepository.findAll().forEach(rsl::add);
        return rsl;
    }
    public Collection<User> getAllUsers(){
        List<User> rsl = new ArrayList<>();
        userRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }

    public void setBookForUser(User user, Book book) {
        Set<Book> usersBooks = new HashSet<>();
        usersBooks.add(book);
        user.setBooks(usersBooks);
    }
}
