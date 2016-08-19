package com.questions.web.questions;

import com.questions.model.Question;
import com.questions.service.QuestionServiceImpl;

import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
public class QuestionListController {

    private QuestionServiceImpl service = new QuestionServiceImpl();

    public List<Question> getAll() {
        return service.getAll();
    }

}
