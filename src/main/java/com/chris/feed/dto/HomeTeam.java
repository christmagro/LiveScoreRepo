
package com.chris.feed.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HomeTeam implements Serializable {

    private static final long serialVersionUID = -6217442003660593258L;
    private String gender;
    private Long id;
    private String name;
    private String slug;
    private List<Object> subTeams;
}
