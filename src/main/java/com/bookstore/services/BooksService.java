package com.bookstore.services;

import com.bookstore.data.BooksDAOInterface;
import com.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BooksService implements BooksServiceInterface {

    @Autowired
    private BooksDAOInterface<Book> bookDAO;

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
