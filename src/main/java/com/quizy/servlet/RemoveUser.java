package com.quizy.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/RemoveUser")
public class RemoveUser {

    @PostMapping
    public String delete(@RequestParam Integer id) {
        return "Error";
    }

}
