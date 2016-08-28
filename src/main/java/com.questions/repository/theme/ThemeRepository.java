package com.questions.repository.theme;

import com.questions.model.Theme;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by T on 28.08.2016.
 */
public interface ThemeRepository {

    Theme save(Theme l);

    Theme get(int id);

    Theme getByName(String name);

    boolean remove(int id) throws OperationNotSupportedException;

    List<Theme> getAll();
}
