package com.bookstore.data;

import java.util.List;

public interface BooksDAOInterface< T > {
    public List<T> getAllBooks();
    public T getById(int id);
    public List<T> searchBooks(String searchTerm);
    public int addBook(T newBook);
    public boolean deleteBook(int id);
    public T updateBook(int idToUpdate, T updatedBook);
}
