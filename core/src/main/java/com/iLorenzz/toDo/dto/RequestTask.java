package com.iLorenzz.toDo.dto;

import java.time.LocalDate;

public record RequestTask(String title, String description, LocalDate taskEndDate, int priority_number) {
}
