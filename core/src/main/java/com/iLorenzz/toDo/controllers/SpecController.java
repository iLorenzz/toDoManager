package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.dto.Task;
import io.Input;
import io.Output;

public class SpecController {
    private static final SpecController specController = new SpecController();
    private static Task currentTask;
    private static TaskController taskController = TaskController.getTaskControllerInstance();

    private SpecController(){}

    public static SpecController getSpecControllerInstance(){
        return specController;
    }

    public void loadOperation(String operation){
        switch(operation){
            case "change title":
                changeTitle();
            case "change description":
                changeDescription();
        }
    }

    private void changeTitle(){
        Output.write("new title: ");
        String newTitle = Input.read();

        taskController.patchTitle(newTitle, currentTask);
    }

    private void changeDescription(){
        Output.write("new description: ");
        String newDescription = Input.read();


    }

    public static void setCurrentTask(Task task){
        currentTask = task;
    }
}
