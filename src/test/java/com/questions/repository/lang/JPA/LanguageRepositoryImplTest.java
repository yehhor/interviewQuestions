package com.questions.repository.lang.JPA;


import com.questions.repository.lang.LanguageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.OperationNotSupportedException;

import static com.questions.LangTestData.*;

/**
 * Created by T on 28.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/spring/spring-app.xml",
        "classpath:/spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles({"JPA", "localhost"})
public class LanguageRepositoryImplTest {

    @Autowired
    private LanguageRepository repository;

    @Test
    public void save() throws Exception {
        repository.save(newOne);
        MATCHER.assertCollectionEquals(testAddNew, repository.getAll());
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(testLang0, repository.get(testLang0.getId()));
    }

    @Test
    public void getByName() throws Exception {
        MATCHER.assertEquals(testLang0, repository.getByName(testLang0.getName()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void remove() throws Exception {

        repository.remove(1);
        MATCHER.assertCollectionEquals(testDeleted, repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        MATCHER.assertCollectionEquals(getAll, repository.getAll());
    }

}