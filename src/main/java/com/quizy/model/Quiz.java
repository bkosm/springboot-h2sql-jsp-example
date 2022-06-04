package com.quizy.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String name;
    private int userId;
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<Question>();
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}