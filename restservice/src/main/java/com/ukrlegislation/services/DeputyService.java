package com.ukrlegislation.services;

import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Deputy;

/**
 * Created by dima on 7/25/15.
 */
@Service
public interface DeputyService {

    public Iterable<Deputy> getAll();

    public void add(Deputy deputy);

    public void delete(Long id);

    public Deputy getById(Long id);

    public void getByName(String name);
}
