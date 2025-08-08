package org.muskan.parkinglot.entities;

import org.muskan.parkinglot.entities.ParkingSpot;
import org.muskan.parkinglot.vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;


public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeStamp;
    private long exitTimeStamp;

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.entryTimeStamp=new Date().getTime();
        this.spot=parkingSpot;
        this.vehicle=vehicle;
        this.ticketId= UUID.randomUUID().toString();
    }

    public void setExitTimeStamp() {
        this.exitTimeStamp = new Date().getTime();
    }
}
