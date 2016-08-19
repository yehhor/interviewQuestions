package com.questions.service;

import com.questions.model.Question;
import com.questions.repository.JDBCQuestionRepositoryImpl;
import com.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository dao;

    public List<Question> getAll()
    {
        return dao.getAll();
    }
}
