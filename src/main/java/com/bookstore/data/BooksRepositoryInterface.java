package com.bookstore.data;

import com.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksRepositoryInterface
        extends JpaRepository < Book, Integer > {
    public List<Book> findByCategoryContainingIgnoreCase(String searchTerm);
}
