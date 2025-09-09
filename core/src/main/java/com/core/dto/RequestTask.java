package com.core.dto;

import java.time.LocalDate;

public record RequestTask(String title, String description, LocalDate taskEndDate) {
}
