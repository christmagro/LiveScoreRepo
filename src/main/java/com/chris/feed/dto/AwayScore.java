
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AwayScore implements Serializable {

    private Long current;
    private Long normaltime;
    private Long period1;
}
