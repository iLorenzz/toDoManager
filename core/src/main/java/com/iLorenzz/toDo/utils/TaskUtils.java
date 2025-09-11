package com.iLorenzz.toDo.utils;

import com.iLorenzz.toDo.dto.Task;

import java.util.List;

public final class TaskUtils {
    private TaskUtils(){}

    public static Task getTaskById(int taskId, List<Task> tasks) throws Exception{
        for(Task task : tasks){
            if(task.getTaskId() == taskId){
                return task;
            }
        }

        throw  new Exception();
    }

    public static String[] extractTaskIdFromCommand(String command){
        String[] splitedCommand = command.split("/");
        return splitedCommand;
    }
}
