package com.questions.model;

import javax.persistence.*;

/**
 * Created by yehor on 29.06.2016.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(generator = "global_seq", strategy = GenerationType.SEQUENCE)
    protected Integer id;

    @Column(name = "name")
    protected String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
