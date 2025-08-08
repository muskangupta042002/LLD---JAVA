package org.muskan.parkinglot.fee;

import org.muskan.parkinglot.ParkingTicket;
import org.muskan.parkinglot.vehicle.VehicleType;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private final Map<VehicleType, Double> hourlyRates = Map.of(VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0);
    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long durationInHours = (duration / (1000 * 3600)) + 1;
        return durationInHours * hourlyRates.get(ticket.getVehicle().getType());
    }
}
