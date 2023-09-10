package com.bookstore.controllers;

import com.bookstore.models.Book;
import com.bookstore.models.User;
import com.bookstore.repository.BooksDAOInterface;
import com.bookstore.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("api/v1/bookstore")
public class BorrowController {

    private UserRepositoryInterface userService;
    final BooksDAOInterface< Book > bookService;

    @Autowired
    public BorrowController(UserRepositoryInterface userService, BooksDAOInterface< Book > bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView borrowBook(@PathVariable int id) {

        // Assume that user_1 is the borrower
        User user = userService.findAll().stream().toList().get(1);

        Book book = bookService.getById(id);
        if (book != null) {
            book.setAvailable(false);
            book.setBorrower(user);
            bookService.updateBook(id, book);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("SuccessPage.html");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("FailurePage.html");
            return modelAndView;
        }
    }

    @GetMapping("/reset/{id}")
    public ModelAndView resetBook(@PathVariable int id) {
        Book book = bookService.getById(id);
        if (book != null) {
            book.setAvailable(true);
            book.setBorrower(null);
            bookService.updateBook(id, book);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("SuccessPage.html");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("FailurePage.html");
            return modelAndView;
        }
    }

}
