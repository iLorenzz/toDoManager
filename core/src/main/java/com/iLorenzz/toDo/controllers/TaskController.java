package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.service.TaskService;

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
                createTask();
        }
    }

    private void createTask(){

    }
}
