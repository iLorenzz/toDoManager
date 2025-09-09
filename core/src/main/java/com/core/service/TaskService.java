package com.core.service;

import com.core.dto.RequestTask;
import com.core.dto.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> allTasks = new ArrayList<>();

    public Task createNewTask(RequestTask request){
        Task response = new Task(request.title(), request.description(), request.taskEndDate());
        allTasks.add(response);

        return response;
    }
}
