package com.quizy.model;

import java.util.ArrayList;
import java.util.List;

public class UserQuestionDto {
    private String description;
    private List<UserAnswerDto> answerDtos;

    public UserQuestionDto() {
        answerDtos = new ArrayList<UserAnswerDto>();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<UserAnswerDto> getAnswers() {
        return answerDtos;
    }


    public void setAnswers(List<UserAnswerDto> answerDtos) {
        this.answerDtos = answerDtos;
    }


}
