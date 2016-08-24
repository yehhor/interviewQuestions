package com.questions.model;

/**
 * Created by T on 19.08.2016.
 */
public class Language extends BaseEntity{

    public Language(String name) {
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
