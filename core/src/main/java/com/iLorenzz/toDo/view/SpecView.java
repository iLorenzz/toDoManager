package com.iLorenzz.toDo.view;

import com.iLorenzz.toDo.dto.Task;
import io.Output;

public class SpecView {
    private static final SpecView specView = new SpecView();
    private static final String specOperations = """
                "title": to change the task title
                "description": to update the task description
                "status": to update the task status;
                "back": to return main view
                """;

    private SpecView(){}

    public static SpecView getSpecViewInstance(){
        return specView;
    }

    public void drawView(Task task) {
        Output.write("------------------Change options-------------------", true);
        Output.write(specOperations, true);

        Output.write(task, true);

        Output.write("Choose an element to update: ");
    }
}
