package com.quizy.servlet;

import com.quizy.hub.PointsCalculator;
import com.quizy.model.UserAnswer;
import com.quizy.model.UserDto;
import com.quizy.model.UserQuizDto;
import com.quizy.repo.QuizRepository;
import com.quizy.repo.UserAnswerRepository;
import com.quizy.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Quiz")
public class Quiz {
    private ModelMapper modelMapper;
    private QuizRepository quizRepository;
    private UserAnswerRepository userAnswerRepository;
    private UserRepository userRepository;

    public Quiz(ModelMapper modelMapper,
                QuizRepository quizRepository,
                UserAnswerRepository userAnswerRepository,
                UserRepository userRepository
    ) {
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
        this.userAnswerRepository = userAnswerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ModelAndView get(@RequestParam Integer id, HttpSession session, Model model) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var quiz = quizRepository.findById(id).orElseThrow();

        for (var q : quiz.getQuestions()) {
            for (var a : q.getAnswers()) {
                for (var ua : a.getUserAnswers()) {
                    if (user.getId().equals(ua.getUser().getId())) {
                        return new ModelAndView("quiz-completed");
                    }
                }
            }
        }

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

        for (int i = 0; i < savedQuiz.getQuestions().size(); i++) {
            var q = savedQuiz.getQuestions().get(i);

            for (int j = 0; j < q.getAnswers().size(); j++) {
                var a = q.getAnswers().get(j);
                var userAnswer = quizDto.getQuestions().get(i).getAnswers().get(j);
                userAnswer.setUserId(savedQuiz.getUserId());
                userAnswer.setAnswerId(a.getId());
                var entity = modelMapper.map(userAnswer, UserAnswer.class);
                userAnswerRepository.save(entity);
            }
        }

        var userEntity = userRepository.findById(savedQuiz.getUserId()).orElseThrow();
        var answers = userRepository.findUserAnswersForUserAndQuiz(savedQuiz.getUserId(), savedQuiz.getId());
        //var answers = userEntity.getUserAnswers().stream()         .filter(userAnswer -> userAnswer.getAnswer().getQuestion().getQuiz().getId().equals(savedQuiz.getId())).collect(Collectors.toList());

        var points = PointsCalculator.getPoints(answers);
        userEntity.setPoints(userEntity.getPoints() + points);
        userRepository.save(userEntity);

        return new ModelAndView("redirect:/QuizList");
    }
}
