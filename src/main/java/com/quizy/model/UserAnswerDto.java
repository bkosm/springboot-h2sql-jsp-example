package com.quizy.model;


public class UserAnswerDto {
    private String text;
    private Boolean isCorrect;

    private Integer userId;
    private Integer answerId; // do relacji odpowiedzi użytkownika
    private Integer id; // stare id z klasy odpowiedzi
    private Boolean userSelection;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getUserSelection() {
        return userSelection;
    }

    public void setUserSelection(Boolean userSelection) {
        this.userSelection = userSelection;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
