package com.questions.service.answer;


import com.questions.model.Answer;


import java.util.List;

/**
 * Created by T on 10.09.2016.
 */
public interface AnswerService {

    List<Answer> getAll(Integer id);

    boolean add(Answer answer, Integer id);

    void delete(Integer id);
}
