package com.questions.service;

import com.questions.model.Question;
import com.questions.repository.DataAccesObject;

import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
public class QuestionService {
    private DataAccesObject dao = DataAccesObject.getInstance();

    public List<Question> getAll()
    {
        return dao.getAll();
    }
}
