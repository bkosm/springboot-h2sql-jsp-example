package com.quizy.hub;

import com.quizy.model.AnswerDto;
import com.quizy.model.QuestionDto;
import com.quizy.model.QuizDto;
import com.quizy.model.UserAnswer;

import java.util.List;

public class PointsCalculator {
    public static Integer getPoints(List<UserAnswer> userAnswers) {
        int score = 0;
        for (var ua : userAnswers) {
            var userSelection = ua.getUserSelection();
            var correctAnswer = ua.getAnswer().getCorrect();

            if (userSelection == correctAnswer) {
                score++;
            } else {
                score--;
            }
        }

        return Math.max(score, 0);
    }
}
