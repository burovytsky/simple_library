package com.burovytsky.simple_library.repository;

import com.burovytsky.simple_library.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
}
