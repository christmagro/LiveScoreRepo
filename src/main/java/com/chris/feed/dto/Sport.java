
package com.chris.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sport implements Serializable {

    private AwayScore awayScore;
    private AwayTeam awayTeam;
    private String competition;
    private String competitionId;
    private String country;
    private String countryId;
    private String date;
    private HomeScore homeScore;
    private HomeTeam homeTeam;
    private String id;
    private String liveStatus;
    private String name;
    private Round round;
    private Status status;
    private String time;
    private Long timestamp;

}
