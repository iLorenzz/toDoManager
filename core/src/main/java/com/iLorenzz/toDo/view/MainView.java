package com.iLorenzz.toDo.view;

import io.Output;
import com.iLorenzz.toDo.dto.Task;

import java.util.List;

public class MainView{
    private static final String menu = """
                "create": to create a new task
                "spec/{id}": to access information about a specified task
                "delete/{id}": to delete a task
                "close": to stop the program
                """;
    private static final MainView mainView = new MainView();
    private final String operationMenu;

    private MainView(){
        operationMenu = menu;
    }

    public static MainView getMainViewInstance() {
        return mainView;
    }

    public void drawView(List<Task> allTasks) {
        Output.write(operationMenu, true);

        if(allTasks.isEmpty()){
            Output.write("You don't have a task", true);
            Output.writeNewLine();
        } else {
            allTasks.forEach(System.out::println);
        }

        Output.write("Choose an operation: ");
    }
}
