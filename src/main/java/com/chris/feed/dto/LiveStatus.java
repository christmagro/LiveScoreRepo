package com.chris.feed.dto;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum LiveStatus {

    FULLTIME("FT"),
    HALFTIME("HT"),
    FIRSTHALF("FH"),
    SECONDHALF("SH"),
    CANCELED("Canceled");

    @Getter(AccessLevel.PUBLIC)
    private final String status;

    LiveStatus(String status) {
        this.status = status;
    }


}
