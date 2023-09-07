package com.bookstore.data;

import com.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO implements BooksDAOInterface < Book > {

    @Autowired
    BooksRepositoryInterface bookRepo;

    private JdbcTemplate jdbcTemplate;

    public BooksDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public List< Book > getAllBooks() {
        Iterable<Book> entities = bookRepo.findAll();
        List<Book> books = new ArrayList<>();
        for (Book entity: entities) {
            books.add(modelMapper.map(entity, Book.class));
        }
        return books;
    }

    @Override
    public Book getById(long id) {
        return null;
    }

    @Override
    public List< Book > searchBooks(String searchTerm) {
        return null;
    }

    @Override
    public int addBook(Book newOrder) {
        return 0;
    }

    @Override
    public boolean deleteBook(int id) {
        return false;
    }

    @Override
    public Book updateBook(int idToUpdate, Book updatedBook) {
        return null;
    }
}
