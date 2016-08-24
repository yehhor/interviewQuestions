package com.questions.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yehor on 29.06.2016.
 */
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

    public Question() {

    }

    private String name;

    private Theme theme;

    private Language language;

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
                "name='" + name + '\'' +
                ", theme=" + theme +
                ", language=" + language +
                ", answers=" + answers +
                '}';
    }
}
