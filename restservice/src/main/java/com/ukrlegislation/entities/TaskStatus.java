package com.ukrlegislation.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ramax on 8/1/15.
 */
@Entity
@Table(name = "status")
public class TaskStatus implements Serializable{

    @Id
    private long id;

    private String value;

    public TaskStatus(String value) {
        this.value = value;
    }

    public TaskStatus() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
