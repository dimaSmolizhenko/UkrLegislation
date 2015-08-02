package com.ukrlegislation.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ramax on 8/1/15.
 * Relation between legislators or deputy
 */
@Entity
@Table(name = "relation")
public class RelationPerson implements Serializable{

    @Id
    private long id;

    @Column(name = "unique_person_code_id1")
    private long uniquePersonCodeOne;

    @Column(name = "unique_person_code_id2")
    private long uniquePersonCodeTwo;

    @OneToOne
    @JoinColumn(name = "name_id")
    private RelationName name;

    public RelationPerson(long uniquePersonCodeOne, long uniquePersonCodeTwo) {
        this.uniquePersonCodeOne = uniquePersonCodeOne;
        this.uniquePersonCodeTwo = uniquePersonCodeTwo;
    }

    public RelationPerson() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUniquePersonCodeOne() {
        return uniquePersonCodeOne;
    }

    public void setUniquePersonCodeOne(long uniquePersonCodeOne) {
        this.uniquePersonCodeOne = uniquePersonCodeOne;
    }

    public long getUniquePersonCodeTwo() {
        return uniquePersonCodeTwo;
    }

    public void setUniquePersonCodeTwo(long uniquePersonCodeTwo) {
        this.uniquePersonCodeTwo = uniquePersonCodeTwo;
    }

    @Override
    public String toString() {
        return "RelationPerson{" +
                ", uniquePersonCodeOne=" + uniquePersonCodeOne +
                ", uniquePersonCodeTwo=" + uniquePersonCodeTwo +
                '}';
    }
}
