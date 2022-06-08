package com.quizy.servlet;

import com.quizy.model.UserDto;
import com.quizy.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Account")
public class Account {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public Account(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ModelAndView get(Model model, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var entity = userRepository.findById(user.getId()).orElseThrow();

        model.addAttribute("user", modelMapper.map(entity, UserDto.class));
        return new ModelAndView("my-points");
    }
}
