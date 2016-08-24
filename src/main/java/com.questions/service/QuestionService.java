package com.questions.service;

import com.questions.model.Question;

import java.util.List;

/**
 * Created by T on 19.08.2016.
 */
public interface QuestionService {
    List<Question> getAll();

    List<Question> getByThemeAndLanguage(String theme, String lang);

    List<Question> getByTheme(String theme, String lang);

    List<Question> getByLang(String theme, String lang);

    Question get(int id);

    Question save(Question q);

    boolean delete(int id);

    Question getWithAnswers(int id);

}
