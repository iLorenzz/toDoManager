package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.dto.Task;
import io.Input;
import io.Output;

public class SpecController {
    private static final SpecController specController = new SpecController();
    private static Task currentTask;

    private SpecController(){}

    public static SpecController getSpecControllerInstance(){
        return specController;
    }

    public void loadOperation(String operation) throws Exception{
        switch(operation){
            case "title":
                changeTitle();
                break;
            case "description":
                changeDescription();
                break;
            case "status":
                changeProgressStatus();
                break;
            default:
                throw new Exception();
        }
    }

    private void changeTitle(){
        Output.write("new title: ");
        String newTitle = Input.read();

        TaskController taskController = TaskController.getTaskControllerInstance();
        taskController.patchTitle(newTitle, currentTask);
    }

    private void changeDescription(){
        Output.write("new description: ");
        String newDescription = Input.read();

        TaskController taskController = TaskController.getTaskControllerInstance();
        taskController.patchDescription(newDescription, currentTask);
    }

    private void changeProgressStatus() throws Exception{
        Output.write("""
                1. Active
                2. Completed
                3. Paused
                """, true);
        Output.write("new status: ");
        String newProgressStatus = Input.read();

        TaskController taskController = TaskController.getTaskControllerInstance();
        taskController.patchProgressStatus(Integer.parseInt(newProgressStatus), currentTask);
    }

    public static void setCurrentTask(Task task){
        currentTask = task;
    }
}
