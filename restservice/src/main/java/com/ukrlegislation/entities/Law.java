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
@Table(name = "law")
public class Law implements Serializable {

    @Id
    private long Id;

    @Column(name = "unique_person_code_id")
    private long uniquePersonCode;

    private String name;

    private String description;

    private Date approvalDate;

    public Law() {

    }

    public Law(long uniquePersonCode, String name, String description, Date approvalDate) {
        this.uniquePersonCode = uniquePersonCode;
        this.name = name;
        this.description = description;
        this.approvalDate = approvalDate;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public long getUniquePersonCode() {
        return uniquePersonCode;
    }

    public void setUniquePersonCode(long deputyId) {
        this.uniquePersonCode = deputyId;
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

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
}
