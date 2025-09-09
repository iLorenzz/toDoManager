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

    public static ProgressStatus getProgressStatus(int statusNumber) throws Exception {
        return switch (statusNumber){
            case 1 -> ACTIVE;
            case 2 -> COMPLETED;
            case 3 -> PAUSED;
            default -> throw new Exception();
        };
    }
}
