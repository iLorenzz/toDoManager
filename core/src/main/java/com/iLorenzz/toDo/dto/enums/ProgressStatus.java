package com.iLorenzz.toDo.dto.enums;

public enum ProgressStatus {
    ACTIVE("Active"),
    COMPLETED("Completed"),
    PAUSED("Paused");

    private final String status;

    ProgressStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
