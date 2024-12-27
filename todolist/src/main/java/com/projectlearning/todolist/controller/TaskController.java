package com.projectlearning.todolist.controller;

import com.projectlearning.todolist.model.Task;
import com.projectlearning.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

   private TaskService taskService;

   @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public String findAll(Model model){
       List<Task> taskList=taskService.findAllByOrderByCompletedAsc();
       model.addAttribute("taskList",taskList);
       return "task-list";
    }

    @GetMapping("/remove")
    public String delete(@RequestParam("id") int id){
       taskService.deleteById(id);
       return "redirect:/tasks/list";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model){
       model.addAttribute("task",new Task());
       return "show-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("task") Task task ){
       taskService.save(task);
       return "redirect:/tasks/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,Model model){
       Task task= taskService.findById(id);
       model.addAttribute("task",task);
       return "show-form";
    }

    @PostMapping("/updateStatus")
    public String updateTaskStatus(@RequestParam("id") int id, @RequestParam("completed") boolean completed) {
        // Find the task by id
        Task task = taskService.findById(id);
        if (task != null) {
            task.setCompleted(completed); // Update the completed status
            taskService.save(task); // Save the updated task
        }
        return "redirect:/tasks/list"; // Redirect to the task list
    }



}
