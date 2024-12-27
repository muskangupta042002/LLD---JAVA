package org.muskan.services;

import lombok.NonNull;
import org.muskan.model.Seat;
import org.muskan.model.Show;
import org.muskan.provider.LockProviders;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    private final BookingService bookingService;
    private final LockProviders seatLockProvider;

    public SeatAvailabilityService(@NonNull final BookingService bookingService, @NonNull final LockProviders seatLockProvider){
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(@NonNull final Show show){
        final List<Seat> allSeats = show.getScreen().getSeat();
        final List<Seat> unavailableSeats = getUnavailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }


    public List<Seat> getUnavailableSeats(@NonNull final Show show){
        final List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;

    }

}
