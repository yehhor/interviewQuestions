package com.questions.model;

/**
 * Created by T on 19.08.2016.
 */
public class Theme extends BaseEntity {

    public Theme(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
