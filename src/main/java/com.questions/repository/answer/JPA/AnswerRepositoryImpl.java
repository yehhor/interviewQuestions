package com.questions.repository.answer.JPA;

import com.questions.model.Answer;
import com.questions.model.Question;
import com.questions.repository.answer.AnswerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
@Repository
@Transactional(readOnly = true)
public class AnswerRepositoryImpl implements AnswerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Answer save(Answer a, Integer qId) {

        a.setQuestion(em.find(Question.class, qId));
        if (a.isNew())
            em.persist(a);
        else
            em.merge(a);
        return a;
    }

    @Override
    public Answer get(int id) {
        return em.find(Answer.class, id);
    }


    @Override
    @Transactional
    public void remove(int id) {
        em.remove(em.find(Answer.class, id));
    }

    @Override
    public List<Answer> getAll(Integer id) {
        return em.createNamedQuery(Answer.GET_BY_Q_ID, Answer.class)
                .setParameter("id", id)
                .getResultList();
    }
}
