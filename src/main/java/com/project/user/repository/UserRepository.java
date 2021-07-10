package com.project.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.user.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}