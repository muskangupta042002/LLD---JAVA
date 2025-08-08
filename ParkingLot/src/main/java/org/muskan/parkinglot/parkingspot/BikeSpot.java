package org.muskan.parkinglot.parkingspot;

import org.muskan.parkinglot.vehicle.Vehicle;
import org.muskan.parkinglot.vehicle.VehicleType;

public class BikeSpot extends ParkingSpot{
    public BikeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType()== VehicleType.BIKE;
    }
}
