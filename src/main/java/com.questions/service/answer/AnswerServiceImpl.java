package com.questions.service.answer;

import com.questions.model.Answer;
import com.questions.repository.answer.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by T on 10.09.2016.
 */
@Service
public class AnswerServiceImpl  implements AnswerService{

    @Autowired
    private AnswerRepository repository;

    @Override
    public List<Answer> getAll(Integer id) {
        return repository.getAll(id);
    }

    @Override
    public boolean add(Answer answer, Integer id) {
        return repository.save(answer, id) != null;
    }
}
