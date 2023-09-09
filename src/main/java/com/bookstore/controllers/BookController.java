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

    @GetMapping("/add")
    public ModelAndView addBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AddNewBook.html");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addBook(@ModelAttribute Book book) {
        service.addBook(book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SuccessPage.html");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchBooks(@RequestParam(name = "query") String query, Model model) {
        List<Book> selectedBooks = service.searchBooks(query);
        model.addAttribute("books", selectedBooks);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HomePage.html");
        return modelAndView;
    }
    
    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable(name = "id") int id, Model model) {
        Book book =  service.getById(id);
        model.addAttribute("book", book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BookDetails.html");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable(name = "id") int id) {
        return service.deleteBook(id);
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateBook(@PathVariable(name = "id") int id, Model model) {
        Book book = service.getById(id);
        model.addAttribute("book", book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EditBook.html");
        return modelAndView;
    }

    @PostMapping("/update-book")
    public ModelAndView updateBook(@ModelAttribute Book book, Model model) {
        service.updateBook(book.getId(), book);
        model.addAttribute("book", book);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SuccessPage.html");
        return modelAndView;
    }

}
