
package com.chris.feed.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AwayTeam implements Serializable {

    private String gender;
    private Long id;
    private String name;
    private String slug;
    private List<Object> subTeams;

}
