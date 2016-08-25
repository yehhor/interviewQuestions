package com.questions.repository.JPA;

import com.questions.model.Language;
import com.questions.model.Question;
import com.questions.model.Theme;
import com.questions.repository.QuestionRepository;
import com.questions.util.exception.NotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.questions.model.Language.GET_LANG_ID;
import static com.questions.model.Theme.GET_TH_ID;

/**
 * Created by T on 24.08.2016.
 */
@Repository
@Transactional(readOnly = true)
public class JPAQuestionReposityoryImpl implements QuestionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Question> getAll() {
        return em.createNamedQuery(Question.GET_ALL, Question.class).getResultList();
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        return em.createNamedQuery(Question.GET_BY_THEME_AND_LANG, Question.class)
                .setParameter("theme", theme)
                .setParameter("lang", lang)
                .getResultList();
    }

    @Override
    public Question get(int id) {
        Question q = em.find(Question.class, id);
        if(q == null)
            throw new NotFoundException("entity is not found");
        return q;
    }

    @Transactional
    @Override
    public Question save(Question q)
    {
        q.getTheme().setId(em.createNamedQuery(GET_TH_ID, Number.class)
                .setParameter("name", q.getTheme().getName())
                .getSingleResult().intValue());
        q.getLanguage().setId(em.createNamedQuery(GET_LANG_ID, Number.class)
                .setParameter("name", q.getLanguage().getName())
                .getSingleResult().intValue());
        if (q.isNew()) {
            em.persist(q);
            return q;
        } else {
            return em.merge(q);
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        Question q = em.getReference(Question.class, id);
        em.remove(q);
        return true;
    }

    @Override
    public Question getWithAnswers(int id) {
        return em.createNamedQuery(Question.GET_WITH_ANSWERS, Question.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
