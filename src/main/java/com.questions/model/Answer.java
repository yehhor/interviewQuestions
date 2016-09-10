package com.questions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static com.questions.model.Answer.GET_BY_Q_ID;

/**
 * Created by T on 19.08.2016.
 */
@NamedQueries({
    @NamedQuery(name = GET_BY_Q_ID, query = "select a from Answer a where a.question.id =:id")
})
@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    public static final String GET_BY_Q_ID = "Answer.getByQuestionId";
    @Column(name = "isright")
    private boolean right;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonIgnore
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
                ", questionId=" + question.getId() +
                '}';
    }
}
