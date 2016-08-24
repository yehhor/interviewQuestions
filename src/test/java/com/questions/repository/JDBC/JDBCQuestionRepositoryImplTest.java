package com.questions.repository.JDBC;

import com.questions.model.Question;
import com.questions.repository.QuestionRepository;
import com.questions.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.questions.QuestionTestData.*;


/**
 * Created by T on 20.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, config = @SqlConfig(encoding = "UTF-8"))
public class JDBCQuestionRepositoryImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCQuestionRepositoryImplTest.class);

    @Autowired
    private QuestionRepository repository;

    @Test
    public void getAll() throws Exception {
        List<Question> list = repository.getAll();
        MATCHER.assertCollectionEquals(list, testList);
    }

    @Test
    public void getByThemeAndLanguage() throws Exception {
        MATCHER.assertCollectionEquals(testListJavaOOP, repository.getByThemeAndLanguage("OOP", "Java"));
    }

    @Test(expected = NotFoundException.class)
    public void getByThemeAndLanguageNotFound() throws Exception {
        if(repository.getByThemeAndLanguage("Incorrect", "Test").isEmpty())
            throw new NotFoundException("everything is ok");
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(testQ0, repository.get(testQ0.getId()));
    }

    @Test(expected = DataAccessException.class)
    public void getNotFound() throws Exception {
        repository.get(testNotFound.getId());
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getWithAnswers() throws Exception {

        System.out.println(repository.getWithAnswers(100000));
    }

}