package com.quizy.servlet;

import com.quizy.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Logout")
public class Logout {

    @GetMapping
    public ModelAndView get(HttpSession session) {
        session.removeAttribute("user");
        return new ModelAndView("redirect:/Login");
    }
}
