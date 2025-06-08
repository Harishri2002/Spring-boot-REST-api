package com.springapi.learn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springapi.learn.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // CrudRepository provides basic CRUD operations
    // You can add custom query methods here if needed
}