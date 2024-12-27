package org.muskan.services;

import lombok.NonNull;
import org.muskan.exception.BadRequestException;
import org.muskan.model.Booking;
import org.muskan.model.Seat;
import org.muskan.provider.LockProviders;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    Map<Booking, Integer> bookingFailures;
    private final Integer allowedRetries;
    private final LockProviders seatLockProvider;

    public PaymentService(@NonNull final Integer allowedRetries, LockProviders seatLockProvider){
        this.allowedRetries=allowedRetries;
        this.seatLockProvider=seatLockProvider;
        this.bookingFailures=new HashMap<>();
    }

    public void processPaymentFailed(@NonNull final Booking booking, @NonNull final String user){
        if (!booking.getUser().equals(user)){
            throw new BadRequestException();
        }
        if (!bookingFailures.containsKey(booking)) {
            bookingFailures.put(booking, 0);
        }
        final Integer currentFailuresCount = bookingFailures.get(booking);
        final Integer newFailuresCount = currentFailuresCount+1;
        bookingFailures.put(booking, newFailuresCount);
        if(newFailuresCount > allowedRetries){
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeats(), booking.getUser());
        }
    }
}
