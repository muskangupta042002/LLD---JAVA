package org.muskan.services;

import org.muskan.common.PaymentStatus;
import org.muskan.reservations.VehicleReservation;

public class PaymentService {
    public PaymentStatus processPayment(VehicleReservation reservation, boolean isPaid) {
        if (isPaid) {
            System.out.println("Payment successful for Reservation ID: " + reservation.getReservationId());
            return PaymentStatus.PAID;
        } else {
            System.out.println("Payment failed for Reservation ID: " + reservation.getReservationId());
            return PaymentStatus.FAILED;
        }
    }
}