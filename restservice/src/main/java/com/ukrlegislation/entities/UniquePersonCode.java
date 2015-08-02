package com.ukrlegislation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ramax on 8/2/15.
 */
@Entity
@Table(name = "unique_person_code")
public class UniquePersonCode implements Serializable {

    @Id
    @Column(name = "id")
    private long value;

    public UniquePersonCode(long value) {
        this.value = value;
    }

    public UniquePersonCode() {
    }

    public long getValue() {
        return value;
    }

    public void setValue(long id) {
        this.value = id;
    }

    @Override
    public String toString() {
        return "UniquePersonCode{" +
                "value=" + value +
                '}';
    }
}
