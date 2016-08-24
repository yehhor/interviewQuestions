package com.questions.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yehor on 29.06.2016.
 */
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

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

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Answer> answers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
                ", name='" + name + '\'' +
                ", theme=" + theme +
                ", language=" + language +
                ", answers=" + answers +
                '}';
    }
}
