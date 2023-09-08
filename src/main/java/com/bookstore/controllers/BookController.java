package com.bookstore.controllers;

import com.bookstore.data.BooksDAOInterface;
import com.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
