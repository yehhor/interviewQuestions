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
@Table(name = "themes")
public class Theme extends BaseEntity {

    public Theme(String name) {
        this.name = name;
    }

    public Theme() {
    }

    @OneToMany(mappedBy = "theme")
    private Set<Question> questions;


    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
