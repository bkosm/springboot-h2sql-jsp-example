package com.quizy.servlet;

import com.quizy.model.User;
import com.quizy.model.UserDto;
import com.quizy.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SaveUser")
public class SaveUser {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public SaveUser(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("user") UserDto userDto, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        } else if (user.getIsAdmin()) {
            if (userDto.getPoints() == null) {
                userDto.setPoints(0);
            }
            userRepository.save(modelMapper.map(userDto, User.class));
        }

        return new ModelAndView("redirect:/UserServlet");
    }
}
