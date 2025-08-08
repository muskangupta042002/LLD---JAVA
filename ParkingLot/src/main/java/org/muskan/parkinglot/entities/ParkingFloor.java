package org.muskan.parkinglot.entities;

import org.muskan.parkinglot.vehicle.Vehicle;
import org.muskan.parkinglot.vehicle.VehicleSize;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ConcurrentHashMap<>();

    }

    public void addSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        return parkingSpots.values().stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize))
                .findFirst();
    }

    // TODO read java stream api and practice
    public void displayAvailability(){
        System.out.printf("---- Floor %d Availability ----\n",floorNumber);
        Map<VehicleSize, Long> availableCounts = parkingSpots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));
        for(VehicleSize size: VehicleSize.values()){
            System.out.printf(" %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }

}
