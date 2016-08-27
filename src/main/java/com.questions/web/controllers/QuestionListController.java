package com.questions.web.controllers;

import com.questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by yehor on 29.06.2016.
 */
@Controller
@RequestMapping("/questions")
public class QuestionListController {

    @Autowired
    private QuestionService service;

    @RequestMapping("/all")
    public String getAll(Model model)
    {
        model.addAttribute("questionList", service.getAll());
        return "questionList";
    }

    @RequestMapping("/{id}")
    public String getOne(@PathVariable Integer id , Model model)
    {
        model.addAttribute("question", service.get(id));
        return "oneQuestion";
    }

}
