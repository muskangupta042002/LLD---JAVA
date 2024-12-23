package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

public class AdditionalServices {
    public void addInsurance(VehicleReservation reservation) {
        System.out.println("Insurance added to Reservation ID: " + reservation.getReservationId());
    }

    public void addRoadsideAssistance(VehicleReservation reservation) {
        System.out.println("Roadside Assistance added to Reservation ID: " + reservation.getReservationId());
    }

    public void addAdditionalDriver(VehicleReservation reservation) {
        System.out.println("Additional Driver added to Reservation ID: " + reservation.getReservationId());
    }

    public void addWifi(VehicleReservation reservation) {
        System.out.println("WiFi added to Reservation ID: " + reservation.getReservationId());
    }
}
