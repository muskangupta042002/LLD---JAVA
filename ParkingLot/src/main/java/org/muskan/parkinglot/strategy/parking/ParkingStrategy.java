package org.muskan.parkinglot.strategy.parking;

import org.muskan.parkinglot.entities.ParkingFloor;
import org.muskan.parkinglot.entities.ParkingSpot;
import org.muskan.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
