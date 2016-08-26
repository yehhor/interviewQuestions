package com.questions.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import java.util.Set;

import static com.questions.model.Question.GET_ALL;
import static com.questions.model.Question.GET_BY_THEME_AND_LANG;
import static com.questions.model.Question.GET_WITH_ANSWERS;

/**
 * Created by yehor on 29.06.2016.
 */
@NamedQueries({
    @NamedQuery(name = GET_ALL, query = "SELECT q from Question q LEFT JOIN FETCH q.theme LEFT JOIN FETCH q.language"),
    @NamedQuery(name = GET_WITH_ANSWERS, query = "SELECT q from Question q LEFT JOIN FETCH q.answers WHERE q.id =:id"),
    @NamedQuery(name = GET_BY_THEME_AND_LANG, query = "SELECT q from Question q " +
            "LEFT JOIN FETCH q.theme " +
            "LEFT JOIN FETCH q.language " +
            "WHERE q.language.name=:lang and q.theme.name=:theme ")
})
@Entity
@Table(name = "questions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Question extends BaseEntity {

    public static final String GET_ALL = "Question.getAll";
    public static final String GET_BY_THEME_AND_LANG = "Question.getByThemeAndLang";
    public static final String GET_WITH_ANSWERS = "Question.getWithAnswers";

    public Question(Integer id,
                    String name,
                    String theme,
                    String language
    ) {
        this.id = id;
        this.name = name;
        this.theme = new Theme(theme);
        this.language = new Language(language);
    }

    public Question(String name,
                    String theme,
                    String language
    ) {
        this.name = name;
        this.theme = new Theme(theme);
        this.language = new Language(language);
    }

    public Question() {

    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Theme theme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Language language;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "question")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Answer> answers;

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id = " + id +
                ", name='" + getName() + '\'' +
                ", theme=" + theme +
                ", language=" + language +
                ", answers=" + answers +
                '}';
    }
}
