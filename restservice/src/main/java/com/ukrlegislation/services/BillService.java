package com.ukrlegislation.services;

import com.ukrlegislation.entities.Bill;

/**
 * Created by dima on 7/25/15.
 */
public interface BillService extends BaseCRUD<Bill> {

    public void getByName(String name);

}
