package com.quizy.hub;

import com.quizy.model.Answer;
import com.quizy.model.Question;
import com.quizy.model.Quiz;

public class QuizParser {
    public static Quiz parse(String name, String definition) {
        Quiz quiz = new Quiz();
        int lastQuestion = -1;

        quiz.setName(name);
        for (var line : definition.split("\n")) {
            if (line.charAt(0) == '-') {
                lastQuestion++;
                Question tempQuestion = new Question();
                tempQuestion.setDescription(line.substring(1, line.length() - 1));
                quiz.getQuestions().add(tempQuestion);
            }
            if (line.charAt(0) == '+') {
                var q = quiz.getQuestions().get(lastQuestion);
                var answer = new Answer();
                if (line.charAt(1) == '+') {
                    answer.setText(line.substring(2, line.length() - 1));
                    answer.setCorrect(true);
                } else {
                    answer.setText(line.substring(1, line.length() - 1));
                    answer.setCorrect(false);
                }
                q.getAnswers().add(answer);
                quiz.getQuestions().set(lastQuestion, q);
            }
        }

        return quiz;
    }
}
