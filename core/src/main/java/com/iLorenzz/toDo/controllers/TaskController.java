package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.view.MainView;
import io.Input;
import com.iLorenzz.toDo.dto.RequestTask;
import com.iLorenzz.toDo.dto.Task;
import com.iLorenzz.toDo.service.TaskService;
import com.iLorenzz.toDo.utils.TaskUtils;

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

    public void loadOperation(String operation, int id) throws Exception {
        switch (operation){
            case "create":
                String statusResponse = postTask();
                //TODO: print the status response
                break;
            case "getAll":
                //TODO: print all tasks
                MainView mainView = MainView.getMainViewInstance();
                mainView.drawView(getAll());
                break;
            case "spec":
                spec(id);
                break;
            case "delete":
                statusResponse = delete(id);
                //TODO: print status response
                break;
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
        return taskService.getAllTasks();
    }

    private Task spec(int id) throws Exception{
        Task task = TaskUtils.getTaskById(id, taskService.getAllTasks());
        return task;
    }

    private String delete(int id) throws Exception{
        taskService.removeTask(id);
        return "Ok: deleted";
    }
}
