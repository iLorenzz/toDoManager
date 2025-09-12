package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.dto.Task;
import io.Input;
import io.Output;

public class SpecController {
    private static final SpecController specController = new SpecController();
    private static Task currentTask;
    private static final TaskController taskController = TaskController.getTaskControllerInstance();

    private SpecController(){}

    public static SpecController getSpecControllerInstance(){
        return specController;
    }

    public void loadOperation(String operation) throws Exception{
        switch(operation){
            case "title":
                changeTitle();
            case "description":
                changeDescription();
            case "status":
                changeProgressStatus();
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

        taskController.patchDescription(newDescription, currentTask);
    }

    private void changeProgressStatus() throws Exception{
        Output.write("new status: ");
        String newProgressStatus = Input.read();

        taskController.patchProgressStatus(Integer.parseInt(newProgressStatus), currentTask);
    }

    public static void setCurrentTask(Task task){
        currentTask = task;
    }
}
