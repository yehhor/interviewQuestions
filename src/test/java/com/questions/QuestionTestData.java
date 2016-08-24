package com.questions;

import com.questions.Matcher.ModelMatcher;
import com.questions.model.Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by T on 20.08.2016.
 */
public class QuestionTestData {

    public static Question testQ0 = new Question(100000, "What is your Favorite language?", "RunTime...", "Java");
    public static Question testQ1 = new Question(100001, "What is your unFavorite language?", "RunTime...", "C++");
    public static Question testQ2 = new Question(100002, "Basic programming principle?", "OOP", "Java");
    public static Question testQ3 = new Question(100003, "Class1 extends Class2 what is that mechanims name?", "OOP", "Java");
    public static Question testUpdate = new Question(100003, "Updated", "RunTime...", "C++");
    public static Question testSaveNew = new Question("testNEW", "OOP", "Java");
    public static Question testNotFound = new Question(-50, "mockQuestion", "OOP", "Java");

    public static List<Question> testList = Arrays.asList(testQ0, testQ1, testQ2, testQ3);
    public static List<Question> testListJavaOOP = Arrays.asList(testQ2, testQ3);

    public static ModelMatcher<Question> MATCHER = new ModelMatcher<>(Question.class,
            (expected, actual) -> {
                if (expected == actual) return true;
                return Objects.equals(expected.getId(), actual.getId())
                        && Objects.equals(expected.getName(), actual.getName())
                        && Objects.equals(expected.getTheme().getName(), actual.getTheme().getName())
                        && Objects.equals(expected.getLanguage().getName(), actual.getLanguage().getName());
            });
}
