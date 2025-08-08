package org.muskan.parkinglot.fee;

import org.muskan.parkinglot.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0; // Flat rate per hour

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        long durationInHours = (duration  / (1000*3600) )+1;
        return durationInHours * RATE_PER_HOUR;
    }
}
