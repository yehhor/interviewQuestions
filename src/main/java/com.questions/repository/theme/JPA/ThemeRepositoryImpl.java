package com.questions.repository.theme.JPA;

import com.questions.model.Theme;
import com.questions.repository.theme.ThemeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.questions.model.Theme.GET_ALL;
import static com.questions.model.Theme.GET_BY_NAME;

/**
 * Created by T on 28.08.2016.
 */
@Repository
@Transactional(readOnly = true)
public class ThemeRepositoryImpl implements ThemeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Theme save(Theme l) {
        if(l.isNew())
            em.persist(l);
        else em.merge(l);
        return l;
    }

    @Override
    public Theme get(int id) {
        return em.find(Theme.class, id);
    }

    @Override
    public Theme getByName(String name) {
        return em.createNamedQuery(GET_BY_NAME, Theme.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public boolean remove(int id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public List<Theme> getAll() {
        return em.createNamedQuery(GET_ALL, Theme.class).getResultList();
    }
}
