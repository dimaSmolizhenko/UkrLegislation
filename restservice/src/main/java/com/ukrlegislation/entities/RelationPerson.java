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

    @OneToOne
    @JoinColumn(name = "unique_person_code_id1")
    private UniquePersonCode uniquePersonCodeOne;

    @OneToOne
    @JoinColumn(name = "unique_person_code_id2")
    private UniquePersonCode uniquePersonCodeTwo;

    @OneToOne
    @JoinColumn(name = "name_id")
    private RelationName name;

    public RelationPerson(UniquePersonCode uniquePersonCodeOne, UniquePersonCode uniquePersonCodeTwo) {
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

    public UniquePersonCode getUniquePersonCodeOne() {
        return uniquePersonCodeOne;
    }

    public void setUniquePersonCodeOne(UniquePersonCode uniquePersonCodeOne) {
        this.uniquePersonCodeOne = uniquePersonCodeOne;
    }

    public UniquePersonCode getUniquePersonCodeTwo() {
        return uniquePersonCodeTwo;
    }

    public void setUniquePersonCodeTwo(UniquePersonCode uniquePersonCodeTwo) {
        this.uniquePersonCodeTwo = uniquePersonCodeTwo;
    }

    public RelationName getName() {
        return name;
    }

    public void setName(RelationName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RelationPerson{" +
                ", uniquePersonCodeOne=" + uniquePersonCodeOne +
                ", uniquePersonCodeTwo=" + uniquePersonCodeTwo +
                '}';
    }
}
