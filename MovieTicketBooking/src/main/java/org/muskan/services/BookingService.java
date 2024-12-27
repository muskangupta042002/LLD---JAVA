package org.muskan.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.muskan.exception.BadRequestException;
import org.muskan.exception.NotFoundException;
import org.muskan.exception.SeatPermanentlyUnavailableException;
import org.muskan.model.Booking;
import org.muskan.model.Seat;
import org.muskan.model.Show;
import org.muskan.provider.LockProviders;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingService {
    final private Map<String, Booking> showBookings;
    final private LockProviders seatLockProvider;

    public BookingService(LockProviders seatLockProvider){
        this.seatLockProvider = seatLockProvider;
        this.showBookings = new HashMap<>();
    }

    public Booking getBooking(@NonNull final String bookingId){
        if(!showBookings.containsKey(bookingId)){
            throw new NotFoundException();
        }
        return showBookings.get(bookingId);
    }

    public List<Booking> getAllBookings(@NonNull final Show show){
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking: showBookings.values()){
            if (booking.getShow().equals(show)){
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public List<Seat> getBookedSeats(Show show){
        return getAllBookings(show).stream().filter(Booking::isConfirmed).map(Booking::getSeats).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public Booking createBooking(@NonNull final String userId, @NonNull final Show show, @NonNull final List<Seat> seats){
        if(isAnySeatAlreadyBooked(show, seats)){
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(show, seats, userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId, show, seats, userId);
        return newBooking;
    }

    public void confirmBooking(@NonNull final Booking booking, @NonNull final String user){
        if(!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        for(Seat seat : booking.getSeats()){
            if(!seatLockProvider.validateLock(booking.getShow(),seat,user)){
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats){
        final List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat: seats){
            if (bookedSeats.contains(seat)){
                return true;
            }
        }
        return false;
    }
}
