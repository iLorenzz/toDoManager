package com.iLorenzz.toDo.service;

import com.iLorenzz.toDo.dto.RequestTask;
import com.iLorenzz.toDo.dto.Task;
import com.iLorenzz.toDo.dto.enums.Priority;
import com.iLorenzz.toDo.utils.TaskUtils;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> allTasks = new ArrayList<>();

    public Task createNewTask(RequestTask request){
        Priority priority = Priority.getPriority(request.priority_number());

        Task response = new Task(request.title(), request.description(), request.taskEndDate(), priority);
        allTasks.add(response);

        return response;
    }

    public List<Task> getAllTasks(){
        return allTasks;
    }

    public void removeTask(int taskId) throws Exception{
        Task toRemoveTask = TaskUtils.getTaskById(taskId, allTasks);

        allTasks.remove(toRemoveTask);
    }
}
