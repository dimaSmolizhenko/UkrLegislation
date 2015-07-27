package com.ukrlegislation.repos;

import org.springframework.data.repository.CrudRepository;
import com.ukrlegislation.entities.Task;

/**
 * Created by dima on 7/25/15.
 */
public interface TaskRepository extends CrudRepository<Task, Long > {

}
