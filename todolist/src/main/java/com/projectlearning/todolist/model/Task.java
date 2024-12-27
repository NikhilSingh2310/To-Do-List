package com.projectlearning.todolist.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="taskDescription")
    private String taskDescription;

    @Column(name="dueDate")
    private LocalDate dueDate;

    @Column(name="completed")
    private boolean completed;

    public Task() {}

    public Task(int id, String taskDescription, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                '}';
    }
}
