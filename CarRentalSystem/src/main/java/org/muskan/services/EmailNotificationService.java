package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

public class EmailNotificationService implements Observer{
    @Override
    public void update(VehicleReservation reservation) {
        System.out.println("Email Notification: Reminder for Reservation ID: " + reservation.getReservationId());
    }
}
