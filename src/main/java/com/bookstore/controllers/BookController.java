package com.bookstore.controllers;

import com.bookstore.data.BooksDAOInterface;
import com.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("api/v1/bookstore")
public class BookController {

    final BooksDAOInterface<Book> service;

    @Autowired
    public BookController(BooksDAOInterface<Book> service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView HomePage(Model model) {
        List<Book> books = service.getAllBooks();
        model.addAttribute("books", books);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage.html");
        return modelAndView;
    }

    @GetMapping("/search/{searchTerm}")
    public  List<Book> searchBooks(@PathVariable(name = "searchTerm") String searchTerm) {
        List<Book> books = service.searchBooks(searchTerm);
        return books;
    }

    @PostMapping("/")
    public long addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable(name = "id") int id) {
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable(name = "id") int id) {
        return service.deleteBook(id);
    }

    @PutMapping("/update/{id}")
    public Book deleteBook(@RequestBody Book book, @PathVariable(name = "id") int id) {
        return service.updateBook(id, book);
    }

}
