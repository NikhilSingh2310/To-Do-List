package com.projectlearning.todolist.service;

import com.projectlearning.todolist.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInterface {

    public List<Task>findAll();
    public Task update(Task task);
    public List<Task> findAllByOrderByCompletedAsc();
    public Task findById(int id);

    void delete(Task task);

    void save(Task task);

    void deleteById(int id);

    public void updateTaskStatus(int id, boolean completed);
}
