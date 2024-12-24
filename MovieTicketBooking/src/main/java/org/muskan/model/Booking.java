package org.muskan.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.muskan.exception.InvalidStateException;

import java.util.List;

@Getter
public class Booking {
    @NonNull
    private final String id;

    @NonNull
    private final Show show;

    @NonNull
    private final List<Seat> seats;

    @NonNull
    private final String user;

    @NonNull
    private BookingStatus bookingStatus;

    public Booking(@NonNull String id, @NonNull Show show, @NonNull List<Seat> seats, @NonNull String user) {
        this.id = id;
        this.show = show;
        this.seats = seats;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public boolean isConfirmed() {
        return this.bookingStatus==BookingStatus.CONFIRMED;
    }

    public void confirmBooking(){
        if(this.bookingStatus != BookingStatus.CREATED){
            throw new InvalidStateException();
        }
        this.bookingStatus=BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if(this.bookingStatus != BookingStatus.CREATED){
            throw new InvalidStateException();
        }
        this.bookingStatus=BookingStatus.EXPIRED;
    }

}
