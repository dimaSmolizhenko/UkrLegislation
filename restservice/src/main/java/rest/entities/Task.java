package rest.entities;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dima on 7/25/15.
 */
@Entity
@Table(name= "task")
public class Task {

    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private String description;
    @Column(name = "send_date")
    private DateTime sendDate;
    @Column(name = "status_id")
    private  Integer statusId;
    private Integer priority;
    @Column(name = "criteria_id")
    private Integer criteriaId;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(DateTime sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }
}
