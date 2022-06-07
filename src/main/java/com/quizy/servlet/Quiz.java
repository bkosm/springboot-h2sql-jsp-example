package com.quizy.servlet;

import com.quizy.model.QuizDto;
import com.quizy.model.UserDto;
import com.quizy.repo.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Quiz")
public class Quiz {
    private ModelMapper modelMapper;
    private QuizRepository quizRepository;

    public Quiz(ModelMapper modelMapper,
                QuizRepository quizRepository) {
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
    }

    @GetMapping
    public ModelAndView get(@RequestParam Integer id, HttpSession session, Model model) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var quiz = quizRepository.findById(id).orElseThrow();
        var quizDto = modelMapper.map(quiz, QuizDto.class);

        model.addAttribute("quiz", quizDto);
        return new ModelAndView("quiz-fill");
    }
}
