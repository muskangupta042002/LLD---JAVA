package org.muskan.parkinglot.parkingspot;

import org.muskan.parkinglot.vehicle.Vehicle;
import org.muskan.parkinglot.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType()== VehicleType.TRUCK;
    }
}
