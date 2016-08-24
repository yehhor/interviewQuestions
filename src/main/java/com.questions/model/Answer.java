package com.questions.model;

/**
 * Created by T on 19.08.2016.
 */
public class Answer extends BaseEntity {

    private String name;

    private boolean right;

    public Answer(String name, boolean right) {
        this.name = name;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
