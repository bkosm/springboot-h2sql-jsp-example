package com.quizy.servlet;

import com.quizy.model.UserDto;
import com.quizy.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/UserForm")
public class UserForm {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserForm(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ModelAndView get(Model model, HttpSession session, @RequestParam(required = false) Integer id) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        if (id == null) {
            model.addAttribute("user", new UserDto());
        } else {
            var forForm = userRepository.findById(id).orElseThrow();
            var dto = modelMapper.map(forForm, UserDto.class);

            model.addAttribute("user", dto);
        }

        return new ModelAndView("user-form");
    }
}
