package com.ukrlegislation.entities;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "unique_person_code_id")
    private UniquePersonCode uniquePersonCode;

    private String name;

    private String description;

    private Date approvalDate;

    public Law() {
    }

    public Law(String name, UniquePersonCode uniquePersonCode, String description, Date approvalDate) {
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

    public UniquePersonCode getUniquePersonCode() {
        return uniquePersonCode;
    }

    public void setUniquePersonCode(UniquePersonCode uniquePersonCode) {
        this.uniquePersonCode = uniquePersonCode;
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
