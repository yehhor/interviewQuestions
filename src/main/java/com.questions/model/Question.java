package com.questions.model;

import java.sql.Array;

/**
 * Created by yehor on 29.06.2016.
 */
public class Question extends BaseEntity {

    public Question(Integer id,
                    String question,
                    String theme,
                    String language) {
        this.id = id;
        this.question = question;
        this.theme = theme;
        this.language = language;
    }

    public Question() {

    }

    private String question;

    private String answer;

    private String wanswer0;

    private String wanswer1;

    private String wanswer2;

    private String theme;

    private String language;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWanswer0() {
        return wanswer0;
    }

    public void setWanswer0(String wanswer0) {
        this.wanswer0 = wanswer0;
    }

    public String getWanswer1() {
        return wanswer1;
    }

    public void setWanswer1(String wanswer1) {
        this.wanswer1 = wanswer1;
    }

    public String getWanswer2() {
        return wanswer2;
    }

    public void setWanswer2(String wanswer2) {
        this.wanswer2 = wanswer2;
    }


    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", wanswer0='" + wanswer0 + '\'' +
                ", wanswer1='" + wanswer1 + '\'' +
                ", wanswer2='" + wanswer2 + '\'' +
                ", theme='" + theme + '\'' +
                ", language=" + language +
                '}';
    }
}
