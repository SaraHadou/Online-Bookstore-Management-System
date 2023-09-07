package com.bookstore.services;

import com.bookstore.models.Book;

import java.util.List;

public interface BooksServiceInterface {

    List< Book > getAllBooks();

    Book getById(long id);

    List< Book > searchBooks(String searchTerm);

    int addBook(Book newBook);

    boolean deleteBook(long id);

    Book updateBook(int idToUpdate, Book updatedBook);

}
