package com.quizy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    public BookController() {
    }

    @GetMapping("/book")
    public String viewBooks(Model model) {
        model.addAttribute("books", new String[]{"atrybut", "drugi", "trzeci"});
        return "view-books";
    }
}
