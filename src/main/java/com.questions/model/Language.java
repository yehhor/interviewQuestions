package com.questions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by T on 19.08.2016.
 */
@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language")
    private Set<Question> questions;

    public String getName() {
        return name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public void setName(String name) {
        this.name = name;
    }
}
