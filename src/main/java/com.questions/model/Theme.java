package com.questions.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Set;

import static com.questions.model.Theme.GET_ALL;
import static com.questions.model.Theme.GET_BY_NAME;
import static com.questions.model.Theme.GET_TH_ID;

/**
 * Created by T on 19.08.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = GET_TH_ID, query = "SELECT id FROM Theme where name = :name"),
                @NamedQuery(name = GET_BY_NAME, query = "SELECT t FROM Theme t where t.name =:name"),
                @NamedQuery(name = GET_ALL, query = "SELECT t from Theme t order by t.name")
        }
)
@Entity
@Table(name = "themes")
public class Theme extends BaseEntity {

    public static final String GET_TH_ID = "Theme.ID";
    public static final String GET_BY_NAME = "Theme.GetByName";
    public static final String GET_ALL = "Theme.getAll";

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
