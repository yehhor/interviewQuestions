package com.questions.service.question;

import com.questions.model.Answer;
import com.questions.model.Question;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by T on 19.08.2016.
 */
public interface QuestionService {
    List<Question> getAll();

    List<Question> getByThemeAndLanguage(String theme, String lang);

    List<Question> getByTheme(String theme, String lang) throws OperationNotSupportedException;

    List<Question> getByLang(String theme, String lang) throws OperationNotSupportedException;

    Question get(int id);

    Question save(Question q);

    boolean delete(int id);

    List<Answer> getAnswers(int id);

}
