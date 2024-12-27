package org.muskan.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.muskan.exception.InvalidStateException;

import java.util.List;

@Getter
public class Booking {

    private final String id;
    private final Show show;
    private final List<Seat> seats;
    private final String user;
    private BookingStatus bookingStatus;

    public Booking(@NonNull String id, @NonNull Show show, @NonNull List<Seat> seats, @NonNull String user) {
        this.id = id;
        this.show = show;
        this.seats = seats;
        this.user = user;
        this.bookingStatus = BookingStatus.CREATED; //mutability
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
