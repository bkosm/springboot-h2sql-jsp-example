package com.quizy.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private String description;
    private List<AnswerDto> answerDtos;

    public QuestionDto() {
        answerDtos = new ArrayList<AnswerDto>();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<AnswerDto> getAnswers() {
        return answerDtos;
    }


    public void setAnswers(List<AnswerDto> answerDtos) {
        this.answerDtos = answerDtos;
    }


}
