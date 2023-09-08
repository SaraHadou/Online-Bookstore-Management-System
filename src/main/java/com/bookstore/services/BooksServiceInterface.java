package com.bookstore.services;

import com.bookstore.models.Book;

import java.util.List;

public interface BooksServiceInterface {

    List< Book > getAllBooks();

    Book getById(int id);

    List< Book > searchBooks(String searchTerm);

    int addBook(Book newBook);

    boolean deleteBook(int id);

    Book updateBook(int idToUpdate, Book updatedBook);

}
