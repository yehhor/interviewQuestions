package com.questions.service;

import com.questions.model.Question;
import com.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Cacheable("questions")
    public List<Question> getAll()
    {
        return repository.getAll();
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        return null;
    }

    @Override
    public List<Question> getByTheme(String theme, String lang) {
        return null;
    }

    @Override
    public List<Question> getByLang(String theme, String lang) {
        return null;
    }

    @Override
    public Question get(int id) {
        return null;
    }

    @CacheEvict(cacheNames = "questions", allEntries = true)
    @Override
    public Question save(Question q) {
        return null;
    }

    @CacheEvict(cacheNames = "questions", allEntries = true)
    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Question getWithAnswers(int id) {
        return null;
    }

    @CacheEvict(cacheNames = "questions", allEntries = true)
    public void evictCache()
    {
    }
}
