package com.quizy.servlet;

import com.quizy.hub.QuizParser;
import com.quizy.model.Quiz;
import com.quizy.model.QuizDto;
import com.quizy.model.User;
import com.quizy.model.UserDto;
import com.quizy.repo.AnswerRepository;
import com.quizy.repo.QuestionRepository;
import com.quizy.repo.QuizRepository;
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
@RequestMapping("/QuizCreator")
public class QuizCreator {
    private ModelMapper modelMapper;
    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;

    public QuizCreator(ModelMapper modelMapper,
                       QuizRepository quizRepository,
                       UserRepository userRepository,
                       QuestionRepository questionRepository,
                       AnswerRepository answerRepository) {
        this.modelMapper = modelMapper;
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping
    public ModelAndView get(HttpSession session, Model model) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        model.addAttribute("quiz", new QuizDto());
        return new ModelAndView("quiz-form");
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("quiz") QuizDto quizDto, HttpSession session) {
        var user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/Login");
        }

        var parsed = QuizParser.parse(quizDto);
        parsed.setUserId(user.getId());
        var userEntity = userRepository.findById(user.getId()).orElseThrow();
        convertAndSaveDatabaseEntity(parsed, userEntity);

        return new ModelAndView("redirect:/QuizList");
    }

    private void convertAndSaveDatabaseEntity(QuizDto dto, User userEntity) {
        var quiz = modelMapper.map(dto, Quiz.class);
        quiz.setUser(userEntity);
        var savedQuiz = quizRepository.save(quiz);

        quiz.getQuestions().forEach(q -> {
            q.setQuiz(savedQuiz);
            var savedQ = questionRepository.save(q);
            q.getAnswers().forEach(a -> {
                a.setQuestion(savedQ);
                answerRepository.save(a);
            });
        });
    }
}
