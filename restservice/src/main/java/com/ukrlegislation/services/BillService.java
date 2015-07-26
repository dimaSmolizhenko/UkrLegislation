package com.ukrlegislation.services;

import com.ukrlegislation.entities.Bill;

/**
 * Created by dima on 7/25/15.
 */
public interface BillService {

    public Iterable<Bill> getAll();

    public void add(Bill bill);

    public void delete(Long id);

    public Bill getById(Long id);

    public void getByName(String name);

}
