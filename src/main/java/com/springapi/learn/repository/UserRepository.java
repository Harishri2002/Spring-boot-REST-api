package com.springapi.learn.repository;


import org.springframework.data.repository.CrudRepository;
import com.springapi.learn.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}