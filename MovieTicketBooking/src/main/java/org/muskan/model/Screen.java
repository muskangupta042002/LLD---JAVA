package org.muskan.model;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
    private final@NonNull String id;
    private final@NonNull String name;
    private final Theatre theatre;
    private final List<Seat> seat;

    public Screen(@NonNull String id,@NonNull String name, @NonNull Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seat = new ArrayList<>();
    }

    public void addSeat(@NonNull final Seat seat){
        this.seat.add(seat);
    }
}
