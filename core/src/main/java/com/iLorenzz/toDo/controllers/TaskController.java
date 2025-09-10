package com.iLorenzz.toDo.controllers;

import com.iLorenzz.io.Input;
import com.iLorenzz.toDo.dto.RequestTask;
import com.iLorenzz.toDo.dto.Task;
import com.iLorenzz.toDo.dto.enums.Priority;
import com.iLorenzz.toDo.service.TaskService;

import java.time.LocalDate;
import java.util.List;

public class TaskController {
    private final TaskService taskService = TaskService.getTaskServiceInstance();
    private static final TaskController taskController = new TaskController();

    private TaskController(){
    }

    public static synchronized TaskController getTaskControllerInstance(){
        return taskController;
    }

    public void loadOperation(String operation){
        switch (operation){
            case "create":
                String statusResponse = postTask();
                //TODO: print the status response
                break;
            case "getAll":
                //TODO: print all tasks
        }
    }

    private String postTask(){
        String newTaskTitle = Input.read();
        String newTaskDescription = Input.read();
        int newTaskPriority = Integer.parseInt(Input.read());
        String newTaskEndDate = Input.read();

        LocalDate formatedNewTaskEndDate = LocalDate.parse(newTaskEndDate);

        taskService.createNewTask(new RequestTask(newTaskTitle, newTaskDescription, formatedNewTaskEndDate, newTaskPriority));
        return "OK: created";
    }

    private List<Task> getAll(){
        TaskService taskService = TaskService.getTaskServiceInstance();
        return taskService.getAllTasks();
    }
}
