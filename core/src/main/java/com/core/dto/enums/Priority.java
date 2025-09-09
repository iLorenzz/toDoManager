package com.core.dto.enums;

public enum Priority {
    CRITICAL,
    HIGH,
    MEDIUM,
    LOW,
    OPTIONAL;

    public static Priority getPriority(int priorityNumber){
        return switch (priorityNumber){
            case 0 -> CRITICAL;
            case 1 -> HIGH;
            case 2 -> MEDIUM;
            case 3 -> LOW;
            case 4 -> OPTIONAL;
            default -> throw new IllegalStateException("Unexpected value: " + priorityNumber);
        };
    }
}
