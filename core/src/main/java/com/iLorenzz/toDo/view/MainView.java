package com.iLorenzz.toDo.view;

import com.iLorenzz.io.Output;
import com.iLorenzz.toDo.dto.Task;
import com.iLorenzz.toDo.service.TaskService;

import java.util.List;

public class MainView extends View{
    private static final String menu = """
                "create": to create a new task
                "spec/{id}": to access information about a specified task
                "delete/{id}": to delete a task
                "close": to stop the program
                """;
    private static final MainView mainView = new MainView();
    private final TaskService taskService = TaskService.getTaskServiceInstance();

    private MainView(){
        super(menu);
    }

    public static MainView getMainViewInstance() {
        return mainView;
    }

    @Override
    public void drawView() {
        List<Task> allTasks = taskService.getAllTasks();
        if(allTasks.isEmpty()){
            Output.write("Tasks are empty");
        } else {
            allTasks.forEach(System.out::println);
        }

        Output.write(operationMenu, true);
        Output.write("Choose an operation: ");
    }
}
