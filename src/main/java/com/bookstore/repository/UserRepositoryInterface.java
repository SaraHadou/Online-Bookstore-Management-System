package com.bookstore.repository;

import com.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepositoryInterface extends JpaRepository< User, Integer > {
    Optional<User> findByEmail(String email);
}
