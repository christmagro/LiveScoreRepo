package com.chris.feed.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SportFeed")
public class SportFeed {

    @Id
    private String id;

    private String firstName;

    private String competition;
    private String liveDetails;
    private String status;
    @Lob
    private String rawValue;


}
