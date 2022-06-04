package com.quizy.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String description;
    private List<Answer> answers;

    public Question() {
        answers = new ArrayList<Answer>();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<Answer> getAnswers() {
        return answers;
    }


    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
