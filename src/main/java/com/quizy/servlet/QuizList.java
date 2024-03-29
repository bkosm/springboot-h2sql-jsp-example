package com.quizy.servlet;

import com.quizy.model.QuizDto;
import com.quizy.model.UserDto;
import com.quizy.repo.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/QuizList")
public class QuizList {
    private ModelMapper modelMapper;
    private QuizRepository quizRepository;

    public QuizList(ModelMapper modelMapper,
                    QuizRepository quizRepository) {
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
    }

    @GetMapping
    public ModelAndView get(HttpSession session, Model model) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var quizes = quizRepository.findAll()
                .stream()
                .map(q -> modelMapper.map(q, QuizDto.class))
                .collect(Collectors.toList());

        model.addAttribute("quizes", quizes);
        return new ModelAndView("quiz-list");
    }
}
