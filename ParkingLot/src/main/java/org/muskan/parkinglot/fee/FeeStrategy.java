package org.muskan.parkinglot.fee;

import org.muskan.parkinglot.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
