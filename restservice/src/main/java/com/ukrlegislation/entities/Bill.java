package com.ukrlegislation.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dima on 7/18/15.
 */
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

    @Id
    private long id;

    @Column(name = "deputy_id")
    private Integer deputyId ;

    private String name ;

    private String description;

    @Column(name = "making_date")
    private Date makingDate;

    public Bill() {

    }

    public Bill(Integer deputyId, String name, String description, Date makingDate) {
        this.deputyId = deputyId;
        this.name = name;
        this.description = description;
        this.makingDate = makingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getDeputyId() {
        return deputyId;
    }

    public void setDeputyId(Integer deputyId) {
        this.deputyId = deputyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMakingDate() {
        return makingDate;
    }

    public void setMakingDate(Date makingDate) {
        this.makingDate = makingDate;
    }
}
