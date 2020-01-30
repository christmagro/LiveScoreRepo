
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Round implements Serializable {

    private Long round;
    private String name;

}
