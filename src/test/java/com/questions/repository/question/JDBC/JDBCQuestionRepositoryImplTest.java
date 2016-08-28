package com.questions.repository.question.JDBC;

import com.questions.model.Question;
import com.questions.repository.question.JPA.JpaUtil;
import com.questions.repository.question.QuestionRepository;
import com.questions.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
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
@Sql(scripts = "classpath:db/populateDB.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles({"JPA", "localhost"})
public class JDBCQuestionRepositoryImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCQuestionRepositoryImplTest.class);

    @Autowired
    private QuestionRepository repository;

    @Autowired
    private JpaUtil util;

    @Before
    public void setUp() throws Exception {
        util.clear2ndLevelHibernateCache();
    }

    @Test
    public void getAll() throws Exception {
        List<Question> list = repository.getAll();
        MATCHER.assertCollectionEquals(testList, list);
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(testQ0, repository.get(testQ0.getId()));
    }

    @Test
    public void getByThemeAndLanguage() throws Exception {
        MATCHER.assertCollectionEquals(testListJavaOOP, repository.getByThemeAndLanguage("OOP", "Java"));
    }

    @Test(expected = NotFoundException.class)
    public void getByThemeAndLanguageNotFound() throws Exception {
        if (repository.getByThemeAndLanguage("Incorrect", "Test").isEmpty())
            throw new NotFoundException("everything is ok");
    }


    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        repository.get(testNotFound.getId());
    }

    @Test
    public void save() throws Exception {
        //ToDo rewrite test to getAll insted
        testSaveNew = repository.save(testSaveNew);
        LOG.info(testSaveNew.toString());
        MATCHER.assertEquals(testSaveNew, repository.get(testSaveNew.getId()));
    }

    @Test
    public void update() throws Exception {
        //ToDo rewrite test to getAll insted
        repository.save(testUpdate);
        MATCHER.assertEquals(testUpdate, repository.get(testUpdate.getId()));
    }

    @Test
    public void delete() throws Exception {
        repository.delete(testQ0.getId());
        MATCHER.assertCollectionEquals(testDelete, repository.getAll());
    }

    @Test(expected = Exception.class)
    public void deleteNotFound() throws Exception {
        if (!repository.delete(5))
            throw new Exception();

    }

    @Test
    public void getWithAnswers() throws Exception {
        Question q = repository.getWithAnswers(testQ0.getId());
        MATCHER.assertEquals(testQ0, q);
    }

}