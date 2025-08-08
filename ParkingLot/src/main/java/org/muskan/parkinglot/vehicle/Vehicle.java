package org.muskan.parkinglot.vehicle;

public abstract class Vehicle {
    String licensePlate;
    VehicleType type;

    public Vehicle(String licensePlate, VehicleType type){
        this.licensePlate=licensePlate;
        this.type=type;
    }

    public String getLicensePlate(){
        return licensePlate;
    }
    public VehicleType getType(){
        return type;
    }
}
