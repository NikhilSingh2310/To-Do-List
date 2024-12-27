package com.projectlearning.todolist.service;

import com.projectlearning.todolist.model.Task;
import com.projectlearning.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInterface{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllByOrderByCompletedAsc() {
        return taskRepository.findAllByOrderByCompletedAsc();
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    public void updateTaskStatus(int id, boolean completed) {
        // Fetch the task by its ID
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        // Update the task's completion status
        task.setCompleted(completed);
        // Save the updated task back to the database
        taskRepository.save(task);
    }
}
