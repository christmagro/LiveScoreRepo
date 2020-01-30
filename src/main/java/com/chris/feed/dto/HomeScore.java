
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HomeScore implements Serializable {

    private static final long serialVersionUID = -3879230920387842616L;
    private Long current;
    private Long normaltime;
    private Long period1;


}
