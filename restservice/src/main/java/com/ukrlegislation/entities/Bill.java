package com.ukrlegislation.entities;


import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "unique_person_code_id")
    private UniquePersonCode uniquePersonCode;

    private String name ;

    private String description;

    @Column(name = "making_date")
    private Date makingDate;

    public Bill() {
    }

    public Bill(String name, UniquePersonCode uniquePersonCode, String description, Date makingDate) {
        this.uniquePersonCode = uniquePersonCode;
        this.name = name;
        this.description = description;
        this.makingDate = makingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getMakingDate() {
        return makingDate;
    }

    public void setMakingDate(Date makingDate) {
        this.makingDate = makingDate;
    }
}
