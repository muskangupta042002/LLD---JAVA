package org.muskan.parkinglot.parkingspot;

import org.muskan.parkinglot.vehicle.Vehicle;
import org.muskan.parkinglot.vehicle.VehicleType;

public class CompactSpot extends ParkingSpot{
    public CompactSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType()== VehicleType.CAR;
    }
}
