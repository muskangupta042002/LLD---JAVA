package org.muskan.vehicles;

import org.muskan.common.VehicleType;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber, String model) {
        super(vehicleNumber, model, VehicleType.TRUCK);
    }
    @Override
    public double calculateRentalPrice() {
        return 7770;
    }
}
