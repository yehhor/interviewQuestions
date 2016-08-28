package com.questions.repository.lang;

import com.questions.model.Language;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
public interface LanguageRepository {

    Language save(Language l);

    Language get(int id);

    Language getByName(String name);

    boolean remove(int id) throws OperationNotSupportedException;

    List<Language> getAll();

}
