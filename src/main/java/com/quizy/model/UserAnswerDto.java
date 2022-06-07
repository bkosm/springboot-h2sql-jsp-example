package com.quizy.model;


public class UserAnswerDto {
    private String text;
    private Boolean isCorrect;

    private Integer userId;
    private Boolean userSelection;

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
