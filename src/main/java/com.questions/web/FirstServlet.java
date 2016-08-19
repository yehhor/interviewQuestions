package com.questions.web;

import com.questions.model.Question;
import com.questions.web.controllers.QuestionListController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
public class FirstServlet extends HttpServlet{

    private ConfigurableApplicationContext appCtx;
    private QuestionListController controller;
    private static final Logger LOG = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    public void init() throws ServletException {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        LOG.info(Arrays.toString(appCtx.getBeanDefinitionNames()));
        controller = (QuestionListController) appCtx.getBean("questionListController");

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

    @Override
    public void destroy() {
        appCtx.close();
        super.destroy();
    }
}


