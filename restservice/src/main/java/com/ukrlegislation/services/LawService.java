package com.ukrlegislation.services;


import com.ukrlegislation.entities.Law;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
public interface LawService extends BaseCRUD<Law> {

    public void getByName(String name);

}
