package com.ukrlegislation.services;

import java.io.Serializable;

/**
 * Created by ramax on 7/27/15.
 */
public interface BaseCRUD<T extends Serializable> {

    public Iterable<T> getAll();

    public void add(T entity);

    public void delete(Long id);

    public T getById(Long id);

    public void update(T entity);

}
