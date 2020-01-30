
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AwayScore implements Serializable {

    private static final long serialVersionUID = -8532738721738665475L;
    private Long current;
    private Long normaltime;
    private Long period1;
}
