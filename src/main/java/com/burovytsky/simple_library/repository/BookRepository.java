package com.burovytsky.simple_library.repository;

import com.burovytsky.simple_library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
