package com.questions.web.controllers;

import com.questions.model.Question;
import com.questions.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Controller
public class QuestionListController {

    @Autowired
    private QuestionServiceImpl service;

    public List<Question> getAll() {
        return service.getAll();
    }

}
