package com.bookstore.repository;

import com.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface BookRepositoryInterface
        extends JpaRepository < Book, Integer > {

    List<Book> findByCategoryContainingIgnoreCase(String searchTerm);

    List<Book> findByBorrowingDateBeforeAndAvailableIsFalse(LocalDateTime dateTime);

}
