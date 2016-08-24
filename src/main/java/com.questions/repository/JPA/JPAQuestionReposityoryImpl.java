package com.questions.repository.JPA;

import com.questions.model.Question;
import com.questions.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by T on 24.08.2016.
 */
@Repository
public class JPAQuestionReposityoryImpl implements QuestionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        return null;
    }

    @Override
    public Question get(int id) {
        return em.find(Question.class, id);
    }

    @Override
    public Question save(Question q) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Question getWithAnswers(int id) {
        return null;
    }
}
