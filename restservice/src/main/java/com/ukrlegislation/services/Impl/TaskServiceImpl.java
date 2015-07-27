package com.ukrlegislation.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Task;
import com.ukrlegislation.repos.TaskRepository;
import com.ukrlegislation.services.TaskService;

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

    public Task getById(Long id) {
        return taskRepository.findOne(id);
    }

    public void update(Task entity) {
        //TODO
    }

    public void getByName(String name) {
        //TODO
    }
}
