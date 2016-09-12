package com.questions.web.controllers;

import com.questions.model.Answer;
import com.questions.model.Question;
import com.questions.service.answer.AnswerService;
import com.questions.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by T on 10.09.2016.
 */
@RestController
@RequestMapping(value = "/rest/q")
public class QuestionRestControlller {

    @Autowired
    private QuestionService service;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> getAll() {

        return service.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @RequestMapping(value = "/getAnswer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Answer> getAnswers(@PathVariable Integer id) {
        return service.getAnswers(id);
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
    public void addAnswer(@RequestParam(name = "questionId") Integer questionId,
                          @RequestParam(name = "text") String text,
                          @RequestParam(name = "right", required = false) Boolean right) {
        Answer a = new Answer();
        a.setName(text);
        if (right != null)
            a.setRight(true);
        answerService.add(a, questionId);
    }

    @RequestMapping(value = "/deleteAnswer/{id}", method = RequestMethod.DELETE)
    public void deleteAnswer(@PathVariable Integer id) {
        answerService.delete(id);
    }

}
