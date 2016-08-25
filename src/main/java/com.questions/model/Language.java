package com.questions.model;

import javax.persistence.*;
import java.util.Set;

import static com.questions.model.Language.GET_LANG_ID;

/**
 * Created by T on 19.08.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = GET_LANG_ID, query = "SELECT id FROM Language where name = :name")
        }
)
@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    public static final String GET_LANG_ID = "Language.ID";

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }


    @OneToMany(mappedBy = "language")
    private Set<Question> questions;


    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

}
