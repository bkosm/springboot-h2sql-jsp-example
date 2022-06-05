package com.quizy.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class QuizDto {
    private Integer id;
    private String name;
    private String definition;

    private int userId;
    private List<QuestionDto> questionDtos;



    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public QuizDto() {
        questionDtos = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<QuestionDto> getQuestions() {
        return questionDtos;
    }

    public void setQuestions(List<QuestionDto> questionDtos) {
        this.questionDtos = questionDtos;
    }
}