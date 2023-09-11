package com.bookstore.repository;

import com.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

public class BookDAO implements BookDAOInterface< Book > {

    @Autowired
    BookRepositoryInterface bookRepo;

    private JdbcTemplate jdbcTemplate;

    public BookDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List< Book > getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List< Book > searchBooks(String searchTerm) {
        return bookRepo.findByCategoryContainingIgnoreCase(searchTerm);
    }

    @Override
    public List< Book > searchBooks(LocalDateTime dateTime) {
        return bookRepo.findByBorrowingDateBeforeAndAvailableIsFalse(dateTime);
    }

    @Override
    public int addBook(Book newBook) {
        Book result =  bookRepo.save(newBook);
        if (result == null) {
            return 0;
        } else {
            return result.getId();
        }
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public boolean deleteBook(int id) {
        bookRepo.deleteById(id);
        return true;
    }

    @Override
    public Book updateBook(int idToUpdate, Book updatedBook) {
        Book existingBook = bookRepo.findById(idToUpdate).orElse(null);

        if (existingBook != null) {
            existingBook.setName(updatedBook.getName());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setPrice(updatedBook.getPrice());
            bookRepo.save(existingBook);
        }
        return existingBook;
    }

}

