package com.bookstore.repository;

import com.bookstore.models.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookDAOInterface< T > {
    public List<T> getAllBooks();
    public T getById(int id);
    public List<T> searchBooks(String searchTerm);
    public List<T> searchBooks(LocalDateTime dateTime);
    public int addBook(T newBook);
    public T save(T book);
    public boolean deleteBook(int id);
    public T updateBook(int idToUpdate, T updatedBook);
}
