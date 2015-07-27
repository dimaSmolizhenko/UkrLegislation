package com.ukrlegislation.services;


import com.ukrlegislation.entities.User;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
public interface UserService extends BaseCRUD<User> {

   public void getByName(String name);

}
