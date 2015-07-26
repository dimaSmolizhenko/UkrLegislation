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
@Table(name= "task")
public class Task implements Serializable {

    @Id
    private long id;

    @Column(name = "user_id")
    private long userId;

    private String description;

    @Column(name = "send_date")
    private Date sendDate;

    @Column(name = "status_id")
    private long statusId;

    private int priority;

    @Column(name = "criteria_id")
    private long criteriaId;

    public Task() {
    }

    public Task(long userId, String description, Date sendDate, long statusId, int priority, long criteriaId) {
        this.userId = userId;
        this.description = description;
        this.sendDate = sendDate;
        this.statusId = statusId;
        this.priority = priority;
        this.criteriaId = criteriaId;
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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(long criteriaId) {
        this.criteriaId = criteriaId;
    }
}
