package com.bookstore.services;

import com.bookstore.repository.UserRepositoryInterface;
import com.bookstore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepositoryInterface userRepo;

    @Override
    public List< User > getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepo.findByEmail(username);
    }

}
