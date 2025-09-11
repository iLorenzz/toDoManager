package com.iLorenzz.toDo.view;

import io.Input;
import io.Output;

import java.util.ArrayList;
import java.util.List;

public class CreateView{
    private static final CreateView createView = new CreateView();

    private CreateView(){
    }

    public static CreateView getCreateViewInstance() {
        return createView;
    }

    public void drawView() {
        String createMessage = "----------Creating new task----------";
        Output.write(createMessage, true);
    }

    public List<String> getRequestBody(){
        List<String> requestBody = new ArrayList<>();

        Output.write("task title: ");
        String newTaskTitle = Input.read();
        requestBody.add(newTaskTitle);

        Output.write("task description: ");
        String newTaskDescription = Input.read();
        requestBody.add(newTaskDescription);

        Output.writeNewLine();

        Output.write("""
                0. Critical
                1. High
                2. Medium
                3. Low
                4. Optional
               
                task priority:
               """);
        String newTaskPriority = Input.read();
        requestBody.add(newTaskPriority);

        Output.writeNewLine();

        Output.write("""
                Format of date: dd/MM/yyyy
                task end date:
                """);
        String newTaskEndDate = Input.read();
        requestBody.add(newTaskEndDate);

        return requestBody;
    }
}
