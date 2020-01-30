
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Status implements Serializable {

    private Long code;
    private String type;

}
