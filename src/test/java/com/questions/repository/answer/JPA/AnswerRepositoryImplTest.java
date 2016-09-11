package com.questions.repository.answer.JPA;

import com.questions.model.Answer;
import com.questions.repository.answer.AnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by T on 10.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/spring/spring-app.xml",
        "classpath:/spring/spring-db.xml"
})
@ActiveProfiles({"JPA", "localhost"})
public class AnswerRepositoryImplTest {

    @Autowired
    private AnswerRepository repository;

    @Test
    public void save() throws Exception {
        Answer a = new Answer();
        a.setName("newOne");
        repository.save(a, 100001);
    }
}
