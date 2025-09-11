package com.iLorenzz.toDo.controllers;

import io.Input;
import com.iLorenzz.toDo.utils.TaskUtils;
import com.iLorenzz.toDo.view.MainView;
import io.Output;

import java.util.List;

public class ApplicationController {
    public static void start() throws Exception {
        //TODO: deserialization

        MainView mainView = MainView.getMainViewInstance();
        TaskController taskController = TaskController.getTaskControllerInstance();
        do{
            taskController.loadOperation("getAll", 0);
            Output.writeNewLine();
            
            String command = Input.read();
            Output.writeNewLine();

            if(command.equals("close")){
                System.exit(0);
            }

            String[] splitedCommand = TaskUtils.extractTaskIdFromCommand(command);
            String operation = splitedCommand[0];

            int taskId;
            if(splitedCommand.length < 2){
                taskId = 0;
            }else{
                taskId = Integer.parseInt(splitedCommand[1]);
            }

            try{
                taskController.loadOperation(operation, taskId);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }
}
