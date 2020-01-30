package com.chris.feed.dto;

import lombok.AccessLevel;
import lombok.Getter;

public enum TypeStatus {


    FINISHED("finished"),
    IN_PROGRESS("inprogress"),
    NOT_STARTED("notstarted"),
    CANCELED("canceled");

    @Getter(AccessLevel.PUBLIC)
    private final String typeStatus;

    TypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }


}
