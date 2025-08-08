package org.muskan.parkinglot.entities;

import org.muskan.parkinglot.vehicle.Vehicle;
import org.muskan.parkinglot.vehicle.VehicleSize;

public class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    private final VehicleSize spotSize;

    public ParkingSpot(String spotId, VehicleSize spotSize){
        this.spotId=spotId;
        this.isOccupied=false;
        this.vehicle=null;
        this.spotSize=spotSize;
    }

    public String getSpotId(){
        return spotId;
    }

    public VehicleSize getSpotSize(){
        return spotSize;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public synchronized boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized void parkVehicle(Vehicle vehicle){

        this.vehicle=vehicle;
        isOccupied=true;
    }

    public synchronized void unParkVehicle(){
        this.vehicle=null;
        isOccupied=false;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(isOccupied) return false;
        return switch (vehicle.getSize()) {
            case LARGE -> spotSize == VehicleSize.LARGE;
            case MEDIUM -> spotSize == VehicleSize.MEDIUM;
            case SMALL -> spotSize == VehicleSize.SMALL;
            default -> false;
        };
    }
}
