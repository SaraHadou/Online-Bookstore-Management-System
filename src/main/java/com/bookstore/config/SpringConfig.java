package com.bookstore.config;

import com.bookstore.repository.BookDAO;
import com.bookstore.repository.BookDAOInterface;
import com.bookstore.repository.UserRepositoryInterface;
import com.bookstore.services.BookService;
import com.bookstore.services.BookServiceInterface;
import com.bookstore.services.UserService;
import com.bookstore.services.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    @Autowired
    DataSource dataSource;

    private final UserRepositoryInterface userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean(name = "UserService")
    @RequestScope
    public UserServiceInterface getUserService() {
        return new UserService();
    }

    @Bean(name = "BookService")
    @RequestScope
    public BookServiceInterface getBookService() {
        return new BookService();
    }

    @Bean(name = "BookDAO")
    @RequestScope
    public BookDAOInterface getDataService() {
        return new BookDAO(dataSource);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

