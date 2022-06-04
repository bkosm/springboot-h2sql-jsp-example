package com.quizy.servlet;

import com.quizy.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Account")
public class Account {

    @GetMapping
    public ModelAndView get(Model model, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        model.addAttribute("user", user);
        return new ModelAndView("my-points");
    }
}
