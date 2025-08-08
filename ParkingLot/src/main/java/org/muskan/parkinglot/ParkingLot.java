package org.muskan.parkinglot;

import org.muskan.parkinglot.entities.ParkingFloor;
import org.muskan.parkinglot.entities.ParkingSpot;
import org.muskan.parkinglot.entities.ParkingTicket;
import org.muskan.parkinglot.strategy.fee.FeeStrategy;
import org.muskan.parkinglot.strategy.fee.FlatRateFeeStrategy;
import org.muskan.parkinglot.strategy.parking.BestFitStrategy;
import org.muskan.parkinglot.strategy.parking.ParkingStrategy;
import org.muskan.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    private ParkingLot() {

        this.feeStrategy = new FlatRateFeeStrategy();
        this.parkingStrategy = new BestFitStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public synchronized Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);

        if (availableSpot.isPresent()) {
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicensePlate(), ticket);
            System.out.printf("%s parked at %s. Ticket:%s\n", vehicle.getLicensePlate());
            return Optional.of(ticket);

        }

        System.out.println("No vaialble spot for " + vehicle.getLicensePlate());
        return Optional.empty();
    }

    public synchronized Optional<Double> unparkVehicle(String license) {
        ParkingTicket ticket = activeTickets.remove(license);
        if (ticket == null) {
            System.out.println("No active ticket found for vehicle with license: " + license);
            return Optional.empty();
        }
        ticket.getSpot().unParkVehicle();
        ticket.setExitTimeStamp();
        activeTickets.remove(ticket.getTicketId());
        return Optional.of(feeStrategy.calculateFee(ticket));


    }
}
