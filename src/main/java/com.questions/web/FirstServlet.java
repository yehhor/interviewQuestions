package com.questions.web;

import com.questions.model.Question;
import com.questions.service.QuestionService;
import com.questions.web.questions.QuestionListController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
public class FirstServlet extends HttpServlet{

    private QuestionListController controller;

    @Override
    public void init() throws ServletException {
        controller = new QuestionListController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Question> questions = controller.getAll();
        req.setAttribute("questionList", questions);
        req.getRequestDispatcher("QuestionList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
