package com.quizy.hub;

import com.quizy.model.AnswerDto;
import com.quizy.model.QuestionDto;
import com.quizy.model.QuizDto;

public class QuizParser {
    public static QuizDto parse(QuizDto dto) {
        var quiz = new QuizDto();
        int lastQuestion = -1;

        quiz.setName(dto.getName());
        quiz.setDefinition(dto.getDefinition());
        for (var line : quiz.getDefinition().split("\n")) {
            if (line.charAt(0) == '-') {
                lastQuestion++;
                QuestionDto tempQuestionDto = new QuestionDto();
                tempQuestionDto.setDescription(line.substring(1, line.length() - 1));
                quiz.getQuestions().add(tempQuestionDto);
            }
            if (line.charAt(0) == '+') {
                var q = quiz.getQuestions().get(lastQuestion);
                var answer = new AnswerDto();
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
