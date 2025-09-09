package com.core.service;

import com.core.dto.RequestTask;
import com.core.dto.Task;
import com.core.dto.enums.Priority;

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
}
