package com.questions.model;

/**
 * Created by yehor on 29.06.2016.
 */
public class Question extends BaseEntity {

    public Question(Integer id, String question, String answer, int theme_id, int language_id) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.theme_id = theme_id;
        this.language_id = language_id;
    }

    public Question()
    {

    }

    private String question;

    private String answer;

    private Integer theme_id;

    private Integer language_id;

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

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", theme_id=" + theme_id +
                ", language_id=" + language_id +
                '}';
    }
}
