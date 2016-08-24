package com.questions.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by yehor on 29.06.2016.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
