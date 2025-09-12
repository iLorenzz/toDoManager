package com.iLorenzz.toDo.dto;


import com.iLorenzz.toDo.dto.enums.Priority;
import com.iLorenzz.toDo.dto.enums.ProgressStatus;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger idCounter = new AtomicInteger();

    public final int taskId;
    public String title;
    public String description;
    public final LocalDate taskInitialDate;
    public LocalDate taskEndDate;
    //Todo status and priority elements
    public ProgressStatus progressStatus;
    public Priority priority;

    public Task(String title, String description, LocalDate taskEndDate, Priority priority){
        this.taskId = idCounter.incrementAndGet();
        this.title = title;
        this.description = description;
        this.taskInitialDate = LocalDate.now();
        this.taskEndDate = taskEndDate;

        this.progressStatus = ProgressStatus.ACTIVE;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTaskInitialDate() {
        return taskInitialDate;
    }

    public LocalDate getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(LocalDate taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getProgressStatus(){
        return progressStatus.getStatus();
    }

    public void setTaskProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskInitialDate=" + taskInitialDate +
                ", taskEndDate=" + taskEndDate +
                ", progressStatus=" + progressStatus +
                ", priority=" + priority +
                '}';
    }
}
