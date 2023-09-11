package com.bookstore.controllers;

import com.bookstore.repository.UserRepositoryInterface;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("api/v1/bookstore")
public class UserController {

    private UserRepositoryInterface service;

    public UserController(UserRepositoryInterface service) {
        this.service = service;
    }

//    @GetMapping("/login")
//    public ModelAndView Login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("LoginForm.html");
//        return modelAndView;
//    }

//    @PostMapping("/login")
//    public ModelAndView Login(@RequestParam("username") String username,
//                              @RequestParam("password") String password,
//                              Model model) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("LoginForm.html");
//        return modelAndView;
//    }

}
