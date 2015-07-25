package rest.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Task;
import rest.repos.TaskRepository;
import rest.services.TaskService;

import java.util.List;

/**
 * Created by dima on 7/25/15.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public void add(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.delete(id);
    }

    public void getById(Long id) {
        taskRepository.findOne(id);
    }

    public void getByName(String name) {

    }
}
