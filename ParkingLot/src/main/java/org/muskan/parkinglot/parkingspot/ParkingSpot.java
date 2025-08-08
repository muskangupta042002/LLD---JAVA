package org.muskan.parkinglot.parkingspot;

import org.muskan.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId){
        this.spotId=spotId;
        this.isOccupied=false;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
    public String getSpotId(){
        return spotId;
    }

    public synchronized void removeVehicle(){
        vehicle=null;
        isOccupied=false;
    }

    public synchronized boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle){
        if(isOccupied) return false;
        this.vehicle=vehicle;
        isOccupied=true;
        return true;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);
}
