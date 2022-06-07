package com.quizy.model;

import java.util.ArrayList;
import java.util.List;

public class UserQuizDto {
    private Integer id;
    private String name;
    private String definition;

    private Integer userId;
    private List<UserQuestionDto> questionDtos;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public UserQuizDto() {
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

    public List<UserQuestionDto> getQuestions() {
        return questionDtos;
    }

    public void setQuestions(List<UserQuestionDto> questionDtos) {
        this.questionDtos = questionDtos;
    }
}