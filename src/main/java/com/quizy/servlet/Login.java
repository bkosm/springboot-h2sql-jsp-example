package com.quizy.servlet;

import com.quizy.model.UserDto;
import com.quizy.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class Login {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public Login(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("user") UserDto userDto, HttpSession session) {
        var user = userRepository.findByName(userDto.getName());
        if (user.getPassword().equals(userDto.getPassword())) {
            var dto = modelMapper.map(user, UserDto.class);
            session.setAttribute("user", dto);
            return new ModelAndView("redirect:/Profile");
        } else {
            return new ModelAndView("no-access");
        }
    }
}
