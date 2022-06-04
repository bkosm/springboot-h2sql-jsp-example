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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/UserServlet")
public class UserServlet {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServlet(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ModelAndView get(Model model, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        } else if (user.getIsAdmin()) {
            var users = userRepository.findAll().stream()
                    .map(u -> modelMapper.map(u, UserDto.class))
                    .collect(Collectors.toList());

            model.addAttribute("listUser", users);
            return new ModelAndView("user-list");
        }

        return new ModelAndView("no-access");
    }
}
