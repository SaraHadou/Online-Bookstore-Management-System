package com.bookstore.services;

import com.bookstore.data.BooksDAOInterface;
import com.bookstore.data.BooksRepositoryInterface;
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
    public Book getById(long id) {
        return null;
    }

    @Override
    public List< Book > searchBooks(String searchTerm) {
        return null;
    }

    @Override
    public int addBook(Book newBook) {
        return 0;
    }

    @Override
    public boolean deleteBook(long id) {
        return false;
    }

    @Override
    public Book updateBook(int idToUpdate, Book updatedBook) {
        return null;
    }
}
