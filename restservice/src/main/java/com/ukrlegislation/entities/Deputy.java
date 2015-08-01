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
@Table(name = "deputy")
public class Deputy implements Serializable {

    @Id
    private long id;

    @Column(name = "full_name")
    private String  fullName;

    @Column(name = "groups")
    private String politGroup;

    @Column(name = "choose_by")
    private String selectedBy;

    @Column(name = "deputy_date")
    private Date selectedDate;

    @Column(name = "encluded_in")
    private String encludedIn;

    @Column(name = "unique_person_code_id")
    private long uniquePersonCode;

    public Deputy() {

    }

    public Deputy(String fullName, String politGroup, String selectedBy, Date selectedDate, String encludedIn) {
        this.fullName = fullName;
        this.politGroup = politGroup;
        this.selectedBy = selectedBy;
        this.selectedDate = selectedDate;
        this.encludedIn = encludedIn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPolitGroup() {
        return politGroup;
    }

    public void setPolitGroup(String politGroup) {
        this.politGroup = politGroup;
    }

    public String getSelectedBy() {
        return selectedBy;
    }

    public void setSelectedBy(String selectedBy) {
        this.selectedBy = selectedBy;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getEncludedIn() {
        return encludedIn;
    }

    public void setEncludedIn(String encludedIn) {
        this.encludedIn = encludedIn;
    }

    public long getUniquePersonCode() {
        return uniquePersonCode;
    }

    public void setUniquePersonCode(long uniquePersonCode) {
        this.uniquePersonCode = uniquePersonCode;
    }
}
