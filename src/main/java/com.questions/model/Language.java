package com.questions.model;

import javax.persistence.*;
import java.util.Set;

import static com.questions.model.Language.GET_ALL;
import static com.questions.model.Language.GET_BY_NAME;
import static com.questions.model.Language.GET_LANG_ID;

/**
 * Created by T on 19.08.2016.
 */
@NamedQueries(
        {
                @NamedQuery(name = GET_LANG_ID, query = "SELECT id FROM Language where name = :name"),
                @NamedQuery(name = GET_ALL, query = "SELECT l FROM Language l order by l.name"),
                @NamedQuery(name = GET_BY_NAME, query = "SELECT l FROM Language l where l.name =:name")
        }
)
@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    public static final String GET_LANG_ID = "Lang.ID";
    public static final String GET_BY_NAME = "Lang.getByName";
    public static final String GET_ALL = "Lang.getAll";

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
