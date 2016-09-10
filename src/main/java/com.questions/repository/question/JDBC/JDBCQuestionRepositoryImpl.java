package com.questions.repository.question.JDBC;

import com.questions.model.Answer;
import com.questions.model.Question;
import com.questions.repository.question.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Repository
public class JDBCQuestionRepositoryImpl implements QuestionRepository {

    private static final Logger LOG = LoggerFactory.getLogger(JDBCQuestionRepositoryImpl.class);

    private SimpleJdbcInsert simpleInsert;

    private RowMapper<Question> questionMAPPER = (rs, i) ->
            new Question(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("theme"),
                    rs.getString("language"));

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public JDBCQuestionRepositoryImpl(DataSource dataSource) {
        simpleInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("questions")
                .usingGeneratedKeyColumns("id")
                .withTableName("languages")
                .withTableName("themes");
    }

    @Override
    public List<Question> getAll() {
        return jdbcTemplate.query("SELECT q.id, q.name, t.name AS theme, l.name AS language " +
                "FROM questions q\n " +
                "JOIN themes t ON t.id=q.theme_id " +
                "JOIN languages l ON l.id=q.language_id " +
                "ORDER BY id", questionMAPPER);
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        String sql = "SELECT q.id, q.name, t.name AS theme, l.name AS language FROM questions q " +
                "JOIN themes t ON t.id=q.theme_id " +
                "JOIN languages l ON l.id=q.language_id " +
                "WHERE t.name = :theme AND l.name = :lang";
        SqlParameterSource map = new MapSqlParameterSource("theme", theme)
                .addValue("lang", lang);
        return namedJdbcTemplate.query(sql, map, questionMAPPER);
    }

    @Override
    public Question get(int id) {
        String sql = "SELECT q.id, q.name, t.name AS theme, l.name AS language " +
                "FROM questions q " +
                "JOIN themes t ON q.theme_id = t.id " +
                "JOIN languages l ON q.language_id = l.id " +
                "WHERE q.id = :id";
        SqlParameterSource map = new MapSqlParameterSource("id", id);
        return namedJdbcTemplate.queryForObject(sql, map, questionMAPPER);
    }

    @Override
    public Question save(Question question) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", question.getId())
                .addValue("questionName", question.getName())
                .addValue("lang", question.getLanguage().getName())
                .addValue("theme", question.getTheme().getName());

        if (question.isNew()) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedJdbcTemplate.update("INSERT INTO questions (name, language_id, theme_id) " +
                    "SELECT :questionName, l.id, t.id FROM themes t " +
                    "JOIN languages l ON l.name = :lang " +
                    "WHERE t.name =:theme", map, keyHolder);
            Number newId = (Number) keyHolder.getKeys().get("id");
            if (newId.intValue() == 0) return null;
            question.setId(newId.intValue());
        } else {
            if (namedJdbcTemplate.update("WITH languages AS (SELECT\n" +
                    "                     l.id AS lang,\n" +
                    "                     t.id AS theme\n" +
                    "                   FROM languages l\n" +
                    "                     JOIN themes t ON t.name = :theme\n" +
                    "                   WHERE l.name = :lang)\n" +
                    "UPDATE questions\n" +
                    "SET name = :questionName, language_id = languages.lang, theme_id = languages.theme FROM languages\n" +
                    "WHERE id = :id ;", map) == 0)
                return null;
        }

        return question;
    }

    @Override
    public boolean delete(int id) {

        return jdbcTemplate.update("DELETE FROM questions WHERE id = " + id) != 0;

    }

    @Override
    @Deprecated
    public List<Answer> getAnswers(int id) {
        String sql = "SELECT a FROM answers a WHERE a.question_id =:id";
        SqlParameterSource map = new MapSqlParameterSource("id", id);
        List<Answer> answers = namedJdbcTemplate.query(sql, map, BeanPropertyRowMapper.newInstance(Answer.class));
        return answers;
    }
}


