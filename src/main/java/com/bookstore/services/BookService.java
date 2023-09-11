package com.bookstore.services;

import com.bookstore.repository.BookDAOInterface;
import com.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookDAOInterface<Book> bookDAO;

    @Override
    public List< Book > getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book getById(int id) {
        return bookDAO.getById(id);
    }

    @Override
    public List< Book > searchBooks(String searchTerm) {
        return bookDAO.searchBooks(searchTerm);
    }

    @Override
    public int addBook(Book newBook) {
        return bookDAO.addBook(newBook);
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDAO.deleteBook(id);
    }

    @Override
    public Book updateBook(int idToUpdate, Book updatedBook) {
        return bookDAO.updateBook(idToUpdate, updatedBook);
    }
}
