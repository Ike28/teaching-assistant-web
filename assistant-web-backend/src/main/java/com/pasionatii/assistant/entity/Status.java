package com.pasionatii.assistant.entity;

public enum Status {
    ASSIGNED("Assigned"),
    EXPIRED("Expired"),
    SUBMITTED("Submitted"),
    SUBMITTED_LATE("Submitted Late");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
