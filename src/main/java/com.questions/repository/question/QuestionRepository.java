package com.questions.repository.question;

import com.questions.model.Language;
import com.questions.model.Question;
import com.questions.model.Theme;

import java.util.List;

/**
 * Created by T on 19.08.2016.
 */

public interface QuestionRepository {

    List<Question> getAll();

    List<Question> getByThemeAndLanguage(String theme, String lang);

    Question get(int id);

    Question save(Question q);

    boolean delete(int id);

    Question getWithAnswers(int id);

}
