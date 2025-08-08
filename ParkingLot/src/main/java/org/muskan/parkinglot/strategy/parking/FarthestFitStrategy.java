package org.muskan.parkinglot.strategy.parking;

import org.muskan.parkinglot.entities.ParkingFloor;
import org.muskan.parkinglot.entities.ParkingSpot;
import org.muskan.parkinglot.vehicle.Vehicle;

import java.util.*;

public class FarthestFitStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        // created a reversed copy of the floors list to search from the top floor down

        List<ParkingFloor> reversedFloors = new ArrayList<>();
        Collections.reverse(reversedFloors);
        for(ParkingFloor floor: reversedFloors){
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
    }
}
