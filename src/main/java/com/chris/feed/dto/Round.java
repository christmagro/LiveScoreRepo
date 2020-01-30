
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Round implements Serializable {

    private static final long serialVersionUID = 736755795722297169L;
    private Long round;
    private String name;

}
