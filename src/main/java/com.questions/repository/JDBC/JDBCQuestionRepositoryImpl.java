package com.questions.repository.JDBC;

import com.questions.model.Question;
import com.questions.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Repository
public class JDBCQuestionRepositoryImpl implements QuestionRepository {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCQuestionRepositoryImpl.class);

    private SimpleJdbcInsert simpleInsert;
    private RowMapper<Question> MAPPER = (rs, i) -> (new Question(rs.getInt("id"),
            rs.getString("question"),
            rs.getString("theme"),
            rs.getString("language")));

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public JDBCQuestionRepositoryImpl(DataSource dataSource) {
        simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("questions")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Question> getAll() {
//        return jdbcTemplate.query("SELECT q.id, question, string_agg(a.name, ',') AS answers, t.name AS theme_name, l.name AS lang_name FROM questions AS q\n" +
//                "JOIN answers AS a ON a.question_id=q.id\n" +
//                "JOIN themes AS t ON t.id=q.theme_id\n" +
//                "JOIN languages AS l ON l.id=q.language_id\n" +
//                "GROUP BY q.id, q.question, t.name, l.name", MAPPER);
        return jdbcTemplate.query("SELECT q.id, q.question, t.name as theme, l.name as language FROM questions q\n" +
                "join themes as t on t.id=q.theme_id\n" +
                "join languages as l on l.id=q.language_id", MAPPER);
    }

    @Override
    public List<Question> getAllByThemeAndLanguage() {
        return null;
    }

    @Override
    public List<Question> getByThemeAndLanguage() {
        return null;
    }

    @Override
    public List<Question> get() {
        return null;
    }

    @Override
    public Question save() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public List<Question> getWithAnswers() {
        return null;
    }
}

