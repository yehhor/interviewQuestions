package com.questions.web.controllers;

import com.questions.model.Question;
import com.questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request)
    {
        String name = request.getParameter("questionName");
        String lang = request.getParameter("lang");
        String theme = request.getParameter("theme");
        service.save(new Question(name, theme, lang));
        return "redirect:/questions/all";
    }

    @RequestMapping(value = "/remove/{id}")
    public String remove(@PathVariable int id)
    {
        service.delete(id);
        return "redirect:/questions/all";
    }

}
