package rest.services;

import rest.entities.Task;

/**
 * Created by dima on 7/25/15.
 */
public interface TaskService {

    public Iterable<Task> getAll();

    public void add(Task task);

    public void delete(Long id);

    public void getById(Long id);

    public void getByName(String name);
}
