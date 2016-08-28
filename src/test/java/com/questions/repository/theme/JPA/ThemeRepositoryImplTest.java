package com.questions.repository.theme.JPA;

import com.questions.repository.theme.ThemeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.OperationNotSupportedException;

import static com.questions.ThemeTestData.*;
import static org.junit.Assert.*;

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
public class ThemeRepositoryImplTest {

    @Autowired
    private ThemeRepository repository;

    @Test
    public void save() throws Exception {
        repository.save(newOne);
        MATCHER.assertCollectionEquals(testAddNew, repository.getAll());
    }

    @Test
    public void get() throws Exception {
        MATCHER.assertEquals(testTheme0, repository.get(1));
    }

    @Test
    public void getByName() throws Exception {
        MATCHER.assertEquals(testTheme0, repository.getByName(testTheme0.getName()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void remove() throws Exception {
        repository.remove(1);
    }

    @Test
    public void getAll() throws Exception {
        MATCHER.assertCollectionEquals(getAll, repository.getAll());
    }

}