package com.ukrlegislation.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ramax on 8/2/15.
 * Relation name for person.
 * Example: friend, family, etc...
 */
@Entity
@Table(name = "relation_name")
public class RelationName implements Serializable{

    @Id
    private long id;

    private String name;

    public RelationName(String name) {
        this.name = name;
    }

    public RelationName() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RelationName{" +
                "name='" + name + '\'' +
                '}';
    }
}
