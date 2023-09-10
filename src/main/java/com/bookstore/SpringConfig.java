package com.bookstore;

import com.bookstore.repository.BooksDAO;
import com.bookstore.repository.BooksDAOInterface;
import com.bookstore.services.BooksService;
import com.bookstore.services.BooksServiceInterface;
import com.bookstore.services.UsersService;
import com.bookstore.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    DataSource dataSource;

    @Bean(name = "UserService")
    @RequestScope
    public UsersServiceInterface getUserService() {
        return new UsersService();
    }

    @Bean(name = "BookService")
    @RequestScope
    public BooksServiceInterface getBookService() {
        return new BooksService();
    }

    @Bean(name = "BookDAO")
    @RequestScope
    public BooksDAOInterface getDataService() {
        return new BooksDAO(dataSource);
    }

}

