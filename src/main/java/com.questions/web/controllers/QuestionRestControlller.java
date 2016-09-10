package com.questions.web.controllers;

import com.questions.model.Answer;
import com.questions.model.Question;
import com.questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by T on 10.09.2016.
 */
@RestController
public class QuestionRestControlller {

    @Autowired
    private QuestionService service;

    @RequestMapping(value = "/rest/q/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getAll() {

        return service.getAll();
    }

    @RequestMapping(value = "/rest/q/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @RequestMapping(value = "/rest/q/getAnswer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Answer> getAnswers(@PathVariable Integer id) {
        return service.getAnswers(id);
    }
}
