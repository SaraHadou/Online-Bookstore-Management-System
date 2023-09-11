package com.bookstore.services;

import com.bookstore.models.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    List< User > getAllUsers();

    Optional<User> getByUsername(String username);

}
