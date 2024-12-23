package org.muskan.services;

import org.muskan.reservations.VehicleReservation;

public interface Observer {
    void update(VehicleReservation reservation);
}
