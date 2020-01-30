
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AwayTeam implements Serializable {

    private static final long serialVersionUID = -5071182580225060867L;
    private String gender;
    private Long id;
    private String name;
    private String slug;
    private List<Object> subTeams;

}
