package com.ukrlegislation.services;


import com.ukrlegislation.entities.Law;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
public interface LawService {

    public List<Law> getAll();

    public void add(Law law);

    public void delete(Long id);

    public Law getById(Long id);

    public void getByName(String name);
}
