package com.iLorenzz.toDo.view;

public abstract class View {
    protected String operationMenu;

    public View(String operationMenu){
        this.operationMenu = operationMenu;
    }

    public void drawView(){}
}
