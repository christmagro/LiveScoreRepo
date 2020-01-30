
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Status implements Serializable {

    private static final long serialVersionUID = -2853430007051332364L;
    private Long code;
    private String type;

}
