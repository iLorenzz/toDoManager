package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.service.TaskService;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


}
