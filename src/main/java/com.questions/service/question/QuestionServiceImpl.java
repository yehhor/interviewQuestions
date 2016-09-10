package com.questions.service.question;

import com.questions.model.Answer;
import com.questions.model.Question;
import com.questions.repository.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Cacheable("questions")
    public List<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Question> getByThemeAndLanguage(String theme, String lang) {
        return repository.getByThemeAndLanguage(theme, lang);
    }

    @Override
    public List<Question> getByTheme(String theme, String lang) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public List<Question> getByLang(String theme, String lang) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public Question get(int id) {
        return repository.get(id);
    }

    @CacheEvict(value = "questions", allEntries = true)
    @Override
    public Question save(Question q) {
        return repository.save(q);
    }

    @CacheEvict(value = "questions", allEntries = true)
    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public List<Answer> getAnswers(int id) {
        //ToDo replace with Answers repository
        return repository.getAnswers(id);
    }

    @CacheEvict(value = "questions", allEntries = true)
    public void evictCache() {
    }
}
