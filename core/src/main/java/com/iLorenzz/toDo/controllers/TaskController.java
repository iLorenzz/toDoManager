package com.iLorenzz.toDo.controllers;

import com.iLorenzz.toDo.view.CreateView;
import com.iLorenzz.toDo.view.MainView;
import io.Input;
import com.iLorenzz.toDo.dto.RequestTask;
import com.iLorenzz.toDo.dto.Task;
import com.iLorenzz.toDo.service.TaskService;
import com.iLorenzz.toDo.utils.TaskUtils;
import io.Output;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskController {
    private final TaskService taskService = TaskService.getTaskServiceInstance();
    private final MainView mainView = MainView.getMainViewInstance();
    private final CreateView createView = CreateView.getCreateViewInstance();
    private final SpecController specController = SpecController.getSpecControllerInstance();

    private static final TaskController taskController = new TaskController();

    private TaskController(){
    }

    public static synchronized TaskController getTaskControllerInstance(){
        return taskController;
    }

    public void loadOperation(String operation, int id) throws Exception {
        String statusResponse;

        switch (operation){
            case "create":
                createView.drawView();
                statusResponse = postTask();
                Output.write(statusResponse, true);
                Output.writeNewLine();
                break;
            case "getAll":
                mainView.drawView(getAll());
                break;
            case "spec":
                spec(id);
                break;
            case "delete":
                statusResponse = delete(id);
                //TODO: print status response
                break;
            default:
                throw new Exception();
        }
    }

    private String postTask() throws Exception{
        List<String> body = createView.getRequestBody();
        if(body.size() != 4){
            throw new Exception();
        }

        String newTaskTitle = body.get(0);
        String newTaskDescription = body.get(1);
        int newTaskPriority = Integer.parseInt(body.get(2));
        String newTaskEndDate = body.get(3);

        LocalDate formatedNewTaskEndDate = LocalDate.parse(newTaskEndDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        taskService.createNewTask(new RequestTask(newTaskTitle, newTaskDescription, formatedNewTaskEndDate, newTaskPriority));
        return "OK: created";
    }

    private List<Task> getAll(){
        return taskService.getAllTasks();
    }

    private void spec(int id) throws Exception{
        Task task = TaskUtils.getTaskById(id, taskService.getAllTasks());
        SpecController.setCurrentTask(task);
        //TODO: call view

        String operation = Input.read();
        specController.loadOperation(operation);

    }

    private String delete(int id) throws Exception{
        taskService.removeTask(id);
        return "Ok: deleted";
    }

    protected void patchTitle(String newTitle, Task task){
        taskService.changeTitle(newTitle, task);
    }

    protected void patchDescription(String newDescription, Task task){
        taskService.changeDescription(newDescription, task);
    }

    protected void patchProgressStatus(int newProgressStatus, Task task)throws Exception{
        taskService.changeStatus(newProgressStatus, task);
    }
}
