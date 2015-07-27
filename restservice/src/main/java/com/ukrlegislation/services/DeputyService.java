package com.ukrlegislation.services;

import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Deputy;

/**
 * Created by dima on 7/25/15.
 */
@Service
public interface DeputyService extends BaseCRUD<Deputy> {

    public void getByName(String name);

}
