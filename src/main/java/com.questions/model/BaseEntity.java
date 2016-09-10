package com.questions.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;

/**
 * Created by yehor on 29.06.2016.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(generator = "global_seq", strategy = GenerationType.SEQUENCE)
    protected Integer id;

    @Column(name = "name")
    @NotEmpty
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

    public boolean isNew()
    {
        return getId() == null;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                ", name='" + name + '\'' +
                '}';
    }
}
