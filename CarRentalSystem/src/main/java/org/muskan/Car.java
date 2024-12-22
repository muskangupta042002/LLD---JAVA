package org.muskan;

import lombok.Data;

@Data
public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String licensePlate;
    private final double rentalPricePerDay;
    private boolean isAvailable;
}
