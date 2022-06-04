package com.quizy.controller;

import com.quizy.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private UserRepository userRepository;

    public BookController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/book")
    public String viewBooks(Model model) {
        model.addAttribute("books", userRepository.findAll());
        return "view-books";
    }
}
