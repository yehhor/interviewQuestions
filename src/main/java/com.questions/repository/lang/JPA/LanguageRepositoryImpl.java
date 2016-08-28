package com.questions.repository.lang.JPA;

import com.questions.model.Language;
import com.questions.repository.lang.LanguageRepository;
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
public class LanguageRepositoryImpl implements LanguageRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Language save(Language l) {

        if(l.isNew())
            em.persist(l);
        else
            em.merge(l);
        return l;
    }

    @Override
    public Language get(int id) {
        return em.find(Language.class, id);
    }

    @Override
    public Language getByName(String name) {
        return em.createNamedQuery(Language.GET_BY_NAME, Language.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    @Transactional
    public boolean remove(int id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public List<Language> getAll() {
        return em.createNamedQuery(Language.GET_ALL, Language.class)
                .getResultList();
    }
}
