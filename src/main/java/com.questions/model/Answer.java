package com.questions.model;

import javax.persistence.*;

/**
 * Created by T on 19.08.2016.
 */
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Column(name = "isright")
    private boolean right;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(String name, boolean right) {
        this.name = name;
        this.right = right;
    }

    public Answer(){}

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question questionId) {
        this.question = questionId;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "name='" + name + '\'' +
                ", right=" + right +
                ", questionId=" + question +
                '}';
    }
}
