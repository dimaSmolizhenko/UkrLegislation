package com.ukrlegislation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dima on 7/25/15.
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    private long id;

    @Column(name = "user_id")
    private long userId;

    private String description;

    @Column(name = "type_date")
    private Date date;

    public Comment() {
    }

    public Comment(long userId, String description, Date date) {
        this.userId = userId;
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
