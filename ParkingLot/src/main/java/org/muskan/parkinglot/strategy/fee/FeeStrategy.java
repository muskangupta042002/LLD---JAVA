package org.muskan.parkinglot.strategy.fee;

import org.muskan.parkinglot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
