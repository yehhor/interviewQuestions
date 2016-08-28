package com.questions.web.controllers;

import com.questions.model.Language;
import com.questions.model.Theme;
import com.questions.repository.lang.LanguageRepository;
import com.questions.repository.theme.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by T on 28.08.2016.
 */
@Controller
public class RootController {

    @Autowired
    private LanguageRepository langRep;

    @Autowired
    private ThemeRepository themeRep;

    @RequestMapping(value = "/theme/add", method = RequestMethod.POST)
    public String addTheme(@RequestParam String themeName)
    {
        themeRep.save(new Theme(themeName));
        return "redirect:/questions/all";
    }

    @RequestMapping(value = "/lang/add", method = RequestMethod.POST)
    public String addLang(@RequestParam String langName)
    {
        langRep.save(new Language(langName));
        return "redirect:/questions/all";
    }
}
