package com.iLorenzz.toDo.view;

public class SpecView implements View{
    private static final SpecView specView = new SpecView();
    private static final String spec = """
                "create": to create a new task
                "spec/{id}": to access information about a specified task
                "delete/{id}": to delete a task
                "close": to stop the program
                """;

    private SpecView(){}

    @Override
    public void drawView() {

    }
}
