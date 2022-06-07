package com.quizy.model;


import javax.persistence.*;

@Entity
@Table(name = "user_answers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_selection")
    private Boolean userSelection;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getUserSelection() {
        return userSelection;
    }

    public void setUserSelection(Boolean userSelection) {
        this.userSelection = userSelection;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
