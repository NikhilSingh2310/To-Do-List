package com.projectlearning.todolist.repository;

import com.projectlearning.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
        public List<Task> findAllByOrderByCompletedAsc();
}
