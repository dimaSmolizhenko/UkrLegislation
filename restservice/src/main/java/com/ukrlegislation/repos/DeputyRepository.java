package com.ukrlegislation.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ukrlegislation.entities.Deputy;

import java.util.Set;

/**
 * Created by dima on 7/25/15.
 */
public interface DeputyRepository extends CrudRepository<Deputy, Long> {

    public Deputy findByUniquePersonCode(long uniquePersonCode);

}
