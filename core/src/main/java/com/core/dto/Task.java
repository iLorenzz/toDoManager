package com.core.dto;


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

    public Task(String title, String description, LocalDate taskEndDate){
        this.taskId = idCounter.incrementAndGet() + 1;
        this.title = title;
        this.description = description;
        this.taskInitialDate = LocalDate.now();
        this.taskEndDate = taskEndDate;
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
}
