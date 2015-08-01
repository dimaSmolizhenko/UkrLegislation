package com.ukrlegislation.entities;


import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    @Column(name = "send_date")
    private Date sendDate;

    @OneToOne
    @JoinColumn(name = "status_id")
    private TaskStatus status;

    private int priority;

    @Column(name = "criteria_id")
    private long criteriaId;

    public Task() {
    }

    public Task(User user, String description, Date sendDate, TaskStatus status, int priority, long criteriaId) {
        this.user = user;
        this.description = description;
        this.sendDate = sendDate;
        this.status = status;
        this.priority = priority;
        this.criteriaId = criteriaId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
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
