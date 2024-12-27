package org.muskan.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.muskan.services.BookingService;
import org.muskan.services.PaymentService;

@AllArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;
    private final BookingService bookingService;

    public void paymentFailed(@NonNull final String bookingId, @NonNull final String user){
        paymentService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(@NonNull final String bookingId, @NonNull final String user){
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}

