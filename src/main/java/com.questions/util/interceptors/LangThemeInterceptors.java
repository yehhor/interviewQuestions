package com.questions.util.interceptors;

import com.questions.repository.lang.LanguageRepository;
import com.questions.repository.theme.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by T on 28.08.2016.
 */

public class LangThemeInterceptors extends HandlerInterceptorAdapter {

    @Autowired
    private ThemeRepository thmRep;

    @Autowired
    private LanguageRepository langRep;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        request.setAttribute("themeList", thmRep.getAll());
        request.setAttribute("langList", langRep.getAll());
    }
}
