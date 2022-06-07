package com.quizy.repo;

import com.quizy.model.User;
import com.quizy.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    @Query("SELECT ua FROM UserAnswer ua JOIN FETCH ua.answer WHERE ua.user.id = ?1 AND ua.answer.question.quiz.id = ?2")
    List<UserAnswer> findUserAnswersForUserAndQuiz(Integer userId, Integer quizId);
}
