package com.questions.model;

import javax.persistence.*;
import java.util.Set;

import static com.questions.model.Theme.GET_TH_ID;

/**
 * Created by T on 19.08.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = GET_TH_ID, query = "SELECT id FROM Theme where name = :name")
        }
)
@Entity
@Table(name = "themes")
public class Theme extends BaseEntity {

    public static final String GET_TH_ID = "Theme.ID";

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
