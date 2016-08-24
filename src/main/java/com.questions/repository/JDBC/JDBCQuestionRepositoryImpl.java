package com.questions.repository.JDBC;

import com.questions.model.Language;
import com.questions.model.Question;
import com.questions.model.Theme;
import com.questions.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Repository
public class JDBCQuestionRepositoryImpl implements QuestionRepository {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCQuestionRepositoryImpl.class);

    private SimpleJdbcInsert simpleInsert;

    private RowMapper<Question> MAPPER = (rs, i) ->
        new Question(rs.getInt("id"),
                rs.getString("question"),
                rs.getString("theme"),
                rs.getString("language"));

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
        return jdbcTemplate.query("SELECT q.id, q.question, t.name AS theme, l.name AS language " +
                "FROM questions q\n " +
                "JOIN themes t ON t.id=q.theme_id " +
                "JOIN languages l ON l.id=q.language_id " +
                "ORDER BY id", MAPPER);
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        String sql = "SELECT q.id, q.question, t.name AS theme, l.name AS language FROM questions q " +
                "JOIN themes t ON t.id=q.theme_id " +
                "JOIN languages l ON l.id=q.language_id " +
                "WHERE t.name = :theme AND l.name = :lang";
        SqlParameterSource map = new MapSqlParameterSource("theme", theme)
                .addValue("lang", lang);
        return namedJdbcTemplate.query(sql, map, MAPPER);
    }

    @Override
    public Question get(int id) {
        String sql = "SELECT q.id, q.question, t.name AS theme, l.name AS language " +
                "FROM questions q " +
                "JOIN themes t ON q.theme_id = t.id " +
                "JOIN languages l ON q.language_id = l.id " +
                "WHERE q.id = :id";
        SqlParameterSource map = new MapSqlParameterSource("id", id);
        return namedJdbcTemplate.queryForObject(sql, map, MAPPER);
    }

    @Override
    public Question save(Question question) {
        SqlParameterSource q = new MapSqlParameterSource()
                .addValue("id", question.getId())
                .addValue("language", question.getLanguage())
                .addValue("theme", question.getTheme());

//        if(question.isNew())
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Question getWithAnswers(int id) {
        String sql = "SELECT q.id, q.question, t.name AS theme, l.name AS language, string_agg(a.name, ',') AS answers, a.isright as right " +
                "FROM questions q " +
                "JOIN themes t ON q.theme_id = t.id " +
                "JOIN languages l ON q.language_id = l.id " +
                "JOIN answers a ON a.question_id = q.id " +
                "WHERE q.id = :id";
        SqlParameterSource map = new MapSqlParameterSource("id", id);
        return namedJdbcTemplate.queryForObject(sql, map, MAPPER);
    }
}


