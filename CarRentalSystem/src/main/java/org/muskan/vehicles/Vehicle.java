package org.muskan.vehicles;

import org.muskan.common.VehicleType;

public abstract class Vehicle {
    private String vehicleNumber;
    private String model;
    private VehicleType type;

    public abstract double calculateRentalPrice();
    public Vehicle(String vehicleNumber, String model, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public VehicleType getType() {
        return type;
    }


}
