package com.questions.repository.answer;

import com.questions.model.Answer;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
public interface AnswerRepository {

    Answer save(Answer l, Integer qId);

    Answer get(int id);

    boolean remove(int id) throws OperationNotSupportedException;

    List<Answer> getAll(Integer questionId);

}
