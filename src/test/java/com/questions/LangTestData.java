package com.questions;

import com.questions.Matcher.ModelMatcher;
import com.questions.model.Language;

import java.util.Arrays;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
public class LangTestData {

    public static Language testLang0 = new Language("Java");
    public static Language testLang1 = new Language("C++");
    public static Language testLang2 = new Language("Python");
    public static Language newOne = new Language("TestNew");
    static
    {
        testLang0.setId(1);
    }
    public static List<Language> getAll = Arrays.asList(testLang1, testLang0, testLang2);
    public static List<Language> testAddNew = Arrays.asList(testLang1, testLang0, testLang2, newOne);
    public static List<Language> testDeleted = Arrays.asList(testLang0, testLang2);

    public static ModelMatcher<Language> MATCHER = new ModelMatcher<>(Language.class,
            ((expected, actual) -> expected.getName().equals(actual.getName())));

}
