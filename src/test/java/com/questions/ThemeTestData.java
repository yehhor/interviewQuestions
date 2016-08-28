package com.questions;

import com.questions.Matcher.ModelMatcher;
import com.questions.model.Theme;

import java.util.Arrays;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
public class ThemeTestData {

    public static Theme testTheme0 = new Theme("OOP");
    public static Theme testTheme1 = new Theme("OOD");
    public static Theme testTheme2 = new Theme("RunTime...");
    public static Theme newOne = new Theme("TestNew");
    static
    {
        testTheme0.setId(1);
    }
    public static List<Theme> getAll = Arrays.asList(testTheme1, testTheme0, testTheme2);
    public static List<Theme> testAddNew = Arrays.asList(testTheme1, testTheme0, testTheme2, newOne);
    public static List<Theme> testDeleted = Arrays.asList(testTheme0, testTheme2);

    public static ModelMatcher<Theme> MATCHER = new ModelMatcher<>(Theme.class,
            ((expected, actual) -> expected.getName().equals(actual.getName())));
}
