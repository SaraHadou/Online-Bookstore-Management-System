package com.bookstore.repository;

import com.bookstore.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositoryInterface
        extends JpaRepository < Role, Integer > {
    Optional<Role> findByName(String name);
}
