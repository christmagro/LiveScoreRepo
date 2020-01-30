package com.chris.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiveScore implements Serializable {
    private static final long serialVersionUID = 1435699530795056922L;
    private List<Sport> livescore;
}
