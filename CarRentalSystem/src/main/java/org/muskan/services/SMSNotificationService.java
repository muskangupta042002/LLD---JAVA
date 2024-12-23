package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

public class SMSNotificationService implements Observer{
    @Override
    public void update(VehicleReservation reservation) {
        System.out.println("SMS Notification: Reminder for Reservation ID: " + reservation.getReservationId());
    }
}
