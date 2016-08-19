package com.questions.repository;

import com.questions.model.Question;

import java.util.List;

/**
 * Created by T on 19.08.2016.
 */

public interface QuestionRepository {
    List<Question> getAll();
}
