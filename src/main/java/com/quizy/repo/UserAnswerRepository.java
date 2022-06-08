package com.quizy.repo;

import com.quizy.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
    @Query("SELECT ua, a FROM UserAnswer ua LEFT JOIN FETCH ua.answer a WHERE ua.user.id = ?1 AND a.question.quiz.id = ?2")
    List<UserAnswer> findUserAnswersForUserAndQuiz(Integer userId, Integer quizId);
}
