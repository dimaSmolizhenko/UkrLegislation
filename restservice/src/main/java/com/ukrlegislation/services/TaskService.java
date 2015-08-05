package com.ukrlegislation.services;

import com.ukrlegislation.entities.Task;

/**
 * Created by dima on 7/25/15.
 */
public interface TaskService extends BaseCRUD<Task> {

   public void getByName(String name);

}
