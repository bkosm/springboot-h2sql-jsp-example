package com.quizy.servlet;

import com.quizy.model.UserAnswer;
import com.quizy.model.UserDto;
import com.quizy.model.UserQuizDto;
import com.quizy.repo.QuizRepository;
import com.quizy.repo.UserAnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/Quiz")
public class Quiz {
    private ModelMapper modelMapper;
    private QuizRepository quizRepository;
    private UserAnswerRepository userAnswerRepository;

    public Quiz(ModelMapper modelMapper,
                QuizRepository quizRepository,
                UserAnswerRepository userAnswerRepository) {
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
        this.userAnswerRepository = userAnswerRepository;
    }

    @GetMapping
    public ModelAndView get(@RequestParam Integer id, HttpSession session, Model model) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var quiz = quizRepository.findById(id).orElseThrow();
        var quizToFill = modelMapper.map(quiz, UserQuizDto.class);

        session.setAttribute("savedQuiz", quizToFill);
        model.addAttribute("quiz", quizToFill);
        return new ModelAndView("quiz-fill");
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("quiz") UserQuizDto quizDto, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        var savedQuiz = (UserQuizDto) session.getAttribute("savedQuiz");
        if (user == null || savedQuiz == null) {
            return new ModelAndView("redirect:/Login");
        }

        var answerList = new ArrayList<UserAnswer>();
        for (int i = 0; i < savedQuiz.getQuestions().size(); i++) {
            var q = savedQuiz.getQuestions().get(i);

            for (int j = 0; j < q.getAnswers().size(); j++) {
                var a = q.getAnswers().get(j);
                var userAnswer = quizDto.getQuestions().get(i).getAnswers().get(j);
                userAnswer.setUserId(savedQuiz.getUserId());
                userAnswer.setAnswerId(a.getId());
                var entity = modelMapper.map(userAnswer, UserAnswer.class);
                answerList.add(entity);
                userAnswerRepository.save(entity);
            }
        }



        return new ModelAndView("redirect:/QuizList");
    }
}
