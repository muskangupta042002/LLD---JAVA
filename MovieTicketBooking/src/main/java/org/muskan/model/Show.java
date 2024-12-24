package org.muskan.model;

import lombok.Data;

import java.util.Date;

@Data
public class Show {
    //show runs for a movie
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final Integer durationInSeconds;
}
